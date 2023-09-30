package com.hugidonic.data.repository

import com.hugidonic.data.converters.toModel
import com.hugidonic.data.converters.toScheduleDayEntity
import com.hugidonic.data.converters.toSubjectEntity
import com.hugidonic.data.converters.toSubjectModel
import com.hugidonic.data.database.ScheduleDao
import com.hugidonic.data.database.SubjectDao
import com.hugidonic.data.remote.ApiService
import com.hugidonic.data.remote.dto.ScheduleDayDto
import com.hugidonic.data.remote.dto.SubjectDto
import com.hugidonic.domain.models.ScheduleDayModel
import com.hugidonic.domain.models.SubjectModel
import com.hugidonic.domain.repositories.ScheduleRepository
import com.hugidonic.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Period
import javax.inject.Inject

class ScheduleRepositoryImpl @Inject constructor(
    private val scheduleDao: ScheduleDao,
    private val subjectDao: SubjectDao,
    private val apiService: ApiService
) : ScheduleRepository {

    override suspend fun getWeekSchedule(
        isFetchFromApi: Boolean,
        typeOfWeek: String
    ): Flow<Resource<List<ScheduleDayModel>>> = flow {
        emit(Resource.Loading(true))

        val localWeekSchedule: List<ScheduleDayModel> = scheduleDao.getWeekScheduleByType(typeOfWeek = typeOfWeek).map {
            ScheduleDayModel(
                scheduleDayId = it.scheduleDayInfo.scheduleDayId,
                dayOfWeek = it.scheduleDayInfo.dayOfWeek,
                typeOfWeek = it.scheduleDayInfo.typeOfWeek,
                date = it.scheduleDayInfo.date,
                subjects = it.subjects.map { subjectEntity -> subjectEntity.toSubjectModel() }
            )
        }

        emit(
            Resource.Success(
                data = localWeekSchedule
            )
        )

        val shouldLoadFromCache = localWeekSchedule.isNotEmpty() && !isFetchFromApi
        if (shouldLoadFromCache) {
            emit(Resource.Loading(false))
            return@flow
        }

        try {
            val weekScheduleDto: List<ScheduleDayDto> = if (typeOfWeek == "Чет") {
                apiService.getChetWeekSchedule()
            } else {
                apiService.getNechetWeekSchedule()
            }
            saveWeekScheduleDtoToDb(weekScheduleDto = weekScheduleDto)
        } catch (e: IOException) {
            emit(Resource.Error(data = localWeekSchedule, message = "Something went wrong..."))
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    data = localWeekSchedule,
                    message = "Couldn't load data from server. Check your internet connection"
                )
            )
        }

        val newWeekScheduleEntities = scheduleDao.getWeekScheduleByType(typeOfWeek = typeOfWeek)

        val newWeekSchedule = newWeekScheduleEntities.map {
            ScheduleDayModel(
                scheduleDayId = it.scheduleDayInfo.scheduleDayId,
                dayOfWeek = it.scheduleDayInfo.dayOfWeek,
                typeOfWeek = it.scheduleDayInfo.typeOfWeek,
                date = it.scheduleDayInfo.date,
                subjects = it.subjects.map { subjectEntity -> subjectEntity.toSubjectModel() }
            )
        }

        emit(
            Resource.Success(
                data = newWeekSchedule
            )
        )
        emit(Resource.Loading(false))
    }

    override suspend fun getSubjectById(subjectId: Int): Flow<Resource<SubjectModel>>  = flow{
        emit(Resource.Loading(true))

        try {
            val localSubject = subjectDao.getSubjectById(subjectId)
            emit(Resource.Success(
                data = localSubject.toSubjectModel()
            ))
            emit(Resource.Loading(false))
        } catch (e: IOException) {
            emit(Resource.Error(
                message = "Couldn't load subject from DB..."
            ))
        }
    }

    override suspend fun getScheduleDayFromDB(typeOfWeek: String, dayOfWeek: String): ScheduleDayModel? {
        val scheduleId = "${typeOfWeek}/${dayOfWeek}"
        val scheduleDayEntity = scheduleDao.getScheduleDay(scheduleDayId = scheduleId)
        return scheduleDayEntity?.toModel()
    }

    private suspend fun saveWeekScheduleDtoToDb(weekScheduleDto: List<ScheduleDayDto>) {
        scheduleDao.clearScheduleDayTable(typeOfWeek = weekScheduleDto[0].typeOfWeek)
        subjectDao.clearSubjectTable()
        weekScheduleDto.forEach { scheduleDayDto ->
            saveScheduleDayDtoToDb(scheduleDayDto = scheduleDayDto)
            saveSubjectsDtoToDb(scheduleDayDto = scheduleDayDto)
        }
    }

    private suspend fun saveScheduleDayDtoToDb(scheduleDayDto: ScheduleDayDto) {
        val scheduleDayEntity = scheduleDayDto.toScheduleDayEntity()
        scheduleDao.insertScheduleDay(scheduleDayEntity = scheduleDayEntity)
    }

    private suspend fun saveSubjectsDtoToDb(scheduleDayDto: ScheduleDayDto) {
        scheduleDayDto.subjects.forEach { subjectDto ->
            val subjectEntity =
                subjectDto.toSubjectEntity(
                    scheduleDayId = "${scheduleDayDto.typeOfWeek}/${scheduleDayDto.dayOfWeek}"
                )
            subjectDao.insertSubject(subjectEntity)
        }
    }

    override fun getTypeOfWeek(): String {
        val currentDate = getCurrentDate()

        val semesterBeginDate = if (currentDate.monthValue in 2..6) {
            LocalDate.of(currentDate.year, 2, 1)
        } else {
            LocalDate.of(currentDate.year, 9, 1)
        }

        val firstWeekMonday = semesterBeginDate.minusDays(semesterBeginDate.dayOfWeek.ordinal.toLong())

        val periodDays = Period.between(firstWeekMonday, currentDate).days
        val weeks = periodDays / 7

        return if ((weeks + 1) % 2 == 0) "Чет" else "Нечет"
    }

    override fun getCurrentDate(): LocalDate {
        val today = LocalDate.now()
        if (today.dayOfWeek != DayOfWeek.SUNDAY) {
            return today
        }
        return today.plusDays(1)
    }
}
