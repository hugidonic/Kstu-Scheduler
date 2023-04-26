package com.hugidonic.data.repository

import com.hugidonic.domain.models.ScheduleDayModel
import com.hugidonic.domain.models.SubjectModel
import com.hugidonic.domain.repositories.ScheduleRepository
import kotlinx.coroutines.delay

class ScheduleRepositoryImpl(): ScheduleRepository {
	override suspend fun getSchedule() {
		TODO("Not yet implemented")
	}

	override suspend fun getSubjectDetails() {
		TODO("Not yet implemented")
	}

	override suspend fun saveSchedule() {
		TODO("Not yet implemented")
	}

	override suspend fun loadSchedule(): ScheduleDayModel {
		delay(2000)
		return ScheduleDayModel(
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