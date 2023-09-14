package com.hugidonic.data.db.scheduleDao.dummyData

import com.hugidonic.domain.models.ScheduleDayModel
import com.hugidonic.domain.models.SubjectModel

object DummyData {
    val weekSchedule = listOf(
        ScheduleDayModel(
            dayOfWeek = "Пн",
            typeOfWeek = "Нечет",
            date = "07.10.2022",
            scheduleDayId = "Нечет/Пн",
            subjects = emptyList()
        ),
        ScheduleDayModel(
            dayOfWeek = "Вт",
            typeOfWeek = "Нечет",
            scheduleDayId = "Нечет/Вт",
            date = "08.11.2022",
            subjects = listOf(
                SubjectModel(
                    title = "Элективные курсы по физической культуре и спорту. Элективные курсы проходят в спортивном комплексе \"МИРАС\"",
                    shortTitle = "Физра",
                    type = "Практика",
                    prepod = "",
                    cabinet = "",
                    duration = "1 сен - 1 янв",
                    startTime = "09:40",
                    endTime = "11:10"
                )
            )
        ),
        ScheduleDayModel(
            dayOfWeek = "Ср",
            typeOfWeek = "Нечет",
            date = "02.11.2022",
            scheduleDayId = "Нечет/Ср",
            subjects = listOf(
                SubjectModel(
                    title = "Средства и системы технического обеспечения обработки, хранения и передачи информации",
                    shortTitle = "СИСТО",
                    type = "Лекция",
                    prepod = "Ильин Г.И.",
                    cabinet = "И-1-209",
                    duration = "1 сен - 1 янв",
                    startTime = "11:20",
                    endTime = "12:50"
                ),
                SubjectModel(
                    title = "Средства и системы технического обеспечения обработки, хранения и передачи информации",
                    shortTitle = "СИСТО",
                    type = "Лабораторная Работа",
                    prepod = "Ильин Г.И.",
                    cabinet = "И-1-204",
                    duration = "1 сен - 1 янв",
                    startTime = "13:00",
                    endTime = "14:30"
                ),
                SubjectModel(
                    title = "Теория вероятностей и математическая статистика",
                    shortTitle = "ТВИМС",
                    type = "Лекция",
                    prepod = "Хайруллин М.Х.",
                    cabinet = "Д-240",
                    duration = "1 сен - 1 янв",
                    startTime = "16:20",
                    endTime = "17:50"
                ),
                SubjectModel(
                    title = "Дискретная математика",
                    shortTitle = "ДМ",
                    type = "Лабораторная Работа",
                    prepod = "Климова А.С.",
                    cabinet = "Д-505",
                    duration = "1 сен - 1 янв",
                    startTime = "18:00",
                    endTime = "19:30"
                ),
            ),
        ),
        ScheduleDayModel(
            dayOfWeek = "Чт",
            typeOfWeek = "Нечет",
            scheduleDayId = "Нечет/Чт",
            date = "03.11.2022",
            subjects = listOf(
                SubjectModel(
                    title = "Информационные технологии в информационной безопасности",
                    shortTitle = "ИТВИБ",
                    type = "Лабораторная Работа",
                    prepod = "Богомолов В.А.",
                    cabinet = "П-7",
                    duration = "1 сен - 4 дек",
                    startTime = "09:40",
                    endTime = "11:10"
                ),
                SubjectModel(
                    title = "Информационные технологии в информационной безопасности",
                    shortTitle = "ИТВИБ",
                    type = "Лекция",
                    prepod = "Богомолов В.А.",
                    cabinet = "П-7",
                    duration = "1 сен - 4 дек",
                    startTime = "11:20",
                    endTime = "12:50"
                ),
                SubjectModel(
                    title = "Основы информационной безопасности",
                    shortTitle = "ОИБ",
                    type = "Лабораторная Работа",
                    prepod = "Садыков А.М.",
                    cabinet = "И-1-204",
                    duration = "1 сен - 4 дек",
                    startTime = "13:00",
                    endTime = "14:30"
                )
            ),
        ),
        ScheduleDayModel(
            dayOfWeek = "Пт",
            typeOfWeek = "Нечет",
            scheduleDayId = "Нечет/Пт",
            date = "04.11.2022",
            subjects = listOf(
                SubjectModel(
                    title = "Элективные курсы по физической культуре и спорту. Элективные курсы проходят в спортивном комплексе \"МИРАС\"",
                    shortTitle = "Физра",
                    type = "Практика",
                    prepod = "",
                    cabinet = "",
                    duration = "1 сен - 1 янв",
                    startTime = "13:00",
                    endTime = "14:30"
                ),
                SubjectModel(
                    title = "Теория вероятностей и математическая статистика",
                    shortTitle = "ТВИМС",
                    type = "Практика",
                    prepod = "Хайруллин М.Х.",
                    cabinet = "Д-104а",
                    duration = "31 окт - 1 янв",
                    startTime = "16:20",
                    endTime = "17:50"
                )
            ),
        ),
        ScheduleDayModel(
            dayOfWeek = "Сб",
            typeOfWeek = "Нечет",
            scheduleDayId = "Нечет/Сб",
            date = "05.11.2022",
            subjects = emptyList()
        )
    )
}