package com.hugidonic.data.repository

import com.hugidonic.data.converters.ScheduleConverter
import com.hugidonic.data.database.ScheduleDao
import com.hugidonic.domain.models.ScheduleDayModel
import com.hugidonic.domain.models.SubjectModel
import com.hugidonic.domain.repositories.ScheduleRepository
import kotlinx.coroutines.delay

class ScheduleRepositoryImpl(
	private val scheduleDao: ScheduleDao,
	private val scheduleConverter: ScheduleConverter
): ScheduleRepository {

	override suspend fun getSchedule(): ScheduleDayModel {
		delay(1000)
		return scheduleConverter.scheduleDbModelToModel(
			scheduleDao.getSchedule(scheduleObject.dayOfWeek)
		)
	}

	override suspend fun getSubjectDetails() {
		TODO("Not yet implemented")
	}

	override suspend fun saveSchedule(scheduleDayModel: ScheduleDayModel) {
		scheduleDao.insertSchedule(
			scheduleConverter.scheduleModelToDbModel(scheduleDayModel=scheduleDayModel)
		)
	}

	override suspend fun loadSchedule() {
		delay(1000)
		saveSchedule(scheduleDayModel = scheduleObject)
	}

	companion object {
		private val scheduleObject = ScheduleDayModel(
			dayOfWeek= "Пн",
			typeOfWeek= "Нечет",
			date="09.12.2022",
			subjects= listOf<SubjectModel?>(
				null,
				SubjectModel(
					title="Основы информационной безопасности",
					shortTitle="ОИБ",
					typeOfSubject="Лекция",
					prepod="Садыков А.М.",
					cabinet="И-1-209",
					date="1 сен - 1 янв"
				),
				null,
				null,
				SubjectModel(
					title= "Информационные технологии в информационной безопасности",
					shortTitle= "ИТВИБ",
					typeOfSubject= "Лабораторная работа",
					prepod= "Богомолов В.А.",
					cabinet= "П-7",
					date= "1 сен - 4 дек"
				),
				SubjectModel(
					title= "Теория вероятностей и математическая статистика",
					shortTitle= "ТВИМС",
					typeOfSubject= "Практика",
					prepod= "Хайруллин М.Х.",
					cabinet= "Д-104а",
					date= "31 окт - 1 янв"
				),
				null,
				null,
			)
		)
	}
}