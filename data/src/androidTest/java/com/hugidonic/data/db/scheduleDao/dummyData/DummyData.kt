package com.hugidonic.data.db.scheduleDao.dummyData

import com.hugidonic.domain.models.SubjectModel

object DummyData {
    val subjects = listOf(
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
}