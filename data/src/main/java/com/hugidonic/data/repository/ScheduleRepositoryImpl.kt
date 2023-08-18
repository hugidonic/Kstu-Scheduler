package com.hugidonic.data.repository

import com.hugidonic.data.converters.toScheduleDayEntity
import com.hugidonic.data.converters.toScheduleDayModel
import com.hugidonic.data.converters.toSubjectEntity
import com.hugidonic.data.converters.toSubjectModel
import com.hugidonic.data.database.ScheduleDao
import com.hugidonic.data.database.entities.ClassEntity
import com.hugidonic.data.remote.ApiService
import com.hugidonic.data.remote.dto.SubjectDto
import com.hugidonic.domain.models.ClassModel
import com.hugidonic.domain.models.ScheduleDayModel
import com.hugidonic.domain.models.SubjectModel
import com.hugidonic.domain.repositories.ScheduleRepository
import com.hugidonic.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ScheduleRepositoryImpl @Inject constructor(
    private val scheduleDao: ScheduleDao,
    private val apiService: ApiService
) : ScheduleRepository {

    override suspend fun getScheduleDayInfo(
        dayOfWeek: String,
    ): Flow<Resource<ScheduleDayModel>> = flow {
        emit(Resource.Loading(true))

        val localScheduleInfo = scheduleDao.getScheduleDay(dayOfWeek)

        localScheduleInfo?.let {
            emit(
                Resource.Success(
                    data = localScheduleInfo.toScheduleDayModel()
                )
            )
        }

        val remoteScheduleDayInfoEntity = try {
            val scheduleDayDto = apiService.getScheduleDayInfo()
            scheduleDayDto.toScheduleDayEntity()
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    data = localScheduleInfo?.toScheduleDayModel(),
                    message = "Couldn't load data, check your internet connection"
                )
            )
            null
        } catch (e: IOException) {
            emit(Resource.Error(data = localScheduleInfo?.toScheduleDayModel(), message = "Couldn't load data"))
            null
        }

        remoteScheduleDayInfoEntity?.let {
            scheduleDao.insertScheduleDay(it)
            emit(
                Resource.Success(
                    data = it.toScheduleDayModel()
                )
            )
        }
    }

    override suspend fun getClasses(
        dayOfWeek: String,
    ): Flow<Resource<List<ClassModel>>> = flow {
        emit(Resource.Loading(true))

        val localClasses = getLocalClasses(dayOfWeek = dayOfWeek)
        emit(Resource.Success(data = localClasses))

        val remoteSubjects = try {
            apiService.getSubjects()
        } catch (e: Exception) {
            emit(Resource.Error(data = null, message = "Couldn't load data"))
            null
        }

        remoteSubjects?.let {
            saveSubjectsToDb(subjects = remoteSubjects, dayOfWeek = dayOfWeek)
            val classesFromDb = getLocalClasses(dayOfWeek = dayOfWeek)
            emit(Resource.Success(data = classesFromDb))
        }
    }

    private suspend fun saveSubjectsToDb(subjects: List<SubjectDto?>, dayOfWeek: String) {
        subjects.forEachIndexed { idx, subjectDto ->
            subjectDto?.let {
                val subjectEntity = subjectDto.toSubjectEntity()
                // Save subject to db
                scheduleDao.insertSubject(subjectEntity)

                // Transform subject to class
                val classEntity = ClassEntity(
                    dayOfWeek = dayOfWeek,
                    orderIndex = idx,
                    subjectTitle = it.title
                )
                // Save class to db
                scheduleDao.insertClass(classEntity)
            }
        }
    }

    private suspend fun getLocalClasses(dayOfWeek: String): List<ClassModel> {
        val subjectsListFromDb = scheduleDao.getSubjectsAndClasses(dayOfWeek = dayOfWeek)
        return subjectsListFromDb.map { subjectAndClass ->
            ClassModel(
                subject = subjectAndClass.subject.toSubjectModel(),
                orderIndex = subjectAndClass.classEntity.orderIndex,
                dayOfWeek = subjectAndClass.classEntity.dayOfWeek
            )
        }
    }

    override suspend fun getSubjectDetails(subjectTitle: String): SubjectModel {
        val subjectEntity = scheduleDao.searchSubject(subjectTitle)
        return subjectEntity.toSubjectModel()
    }
}