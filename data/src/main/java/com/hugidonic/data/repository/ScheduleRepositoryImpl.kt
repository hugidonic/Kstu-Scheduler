package com.hugidonic.data.repository

import com.hugidonic.data.database.ScheduleDao
import com.hugidonic.domain.models.ScheduleDayModel
import com.hugidonic.domain.models.SubjectModel
import com.hugidonic.domain.repositories.ScheduleRepository
import com.hugidonic.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

class ScheduleRepositoryImpl(
	private val scheduleDao: ScheduleDao,
): ScheduleRepository {



	override suspend fun loadSchedule() {
		TODO("Not yet implemented")
	}

	override suspend fun getSchedule(isFetchFromRemote: Boolean): Flow<Resource<ScheduleDayModel>> {
		TODO("Not yet implemented")
	}

	companion object {
		private val scheduleObject = ScheduleDayModel(
			dayOfWeek= "Пн",
			typeOfWeek= "Нечет",
			date="09.12.2022",
			subjects= listOf(
				null,
				SubjectModel(
					subjectTitle="Основы информационной безопасности",
					shortTitle="ОИБ",
					typeOfSubject="Лекция",
					prepod="Садыков А.М.",
					cabinet="И-1-209",
					date="1 сен - 1 янв"
				),
				null,
				null,
				SubjectModel(
					subjectTitle= "Информационные технологии в информационной безопасности",
					shortTitle= "ИТВИБ",
					typeOfSubject= "Лабораторная работа",
					prepod= "Богомолов В.А.",
					cabinet= "П-7",
					date= "1 сен - 4 дек"
				),
				SubjectModel(
					subjectTitle= "Теория вероятностей и математическая статистика",
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