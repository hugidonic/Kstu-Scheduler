package com.hugidonic.domain.dummy

import com.hugidonic.domain.models.PrepodDetailsModel
import com.hugidonic.domain.models.ScheduleDayModel
import com.hugidonic.domain.models.SubjectModel
import kotlin.random.Random

object DummyData {

    val prepodDetails = PrepodDetailsModel(
        info = "Кандидат технических наук\n" +
                "\nИ.о. заведующего кафедрой - Кафедра «Информационная безопасность»\n" +
                "\nДоцент - Кафедра «Информационная безопасность»\n" +
                "\ne-mail: SafiullinaLKh@corp.knrtu.ru",
        subjects_taught = listOf(
            "Машинное обучение",
            "Искусственный интеллект в профессиональной сфере",
            "Программно-аппаратная защита информации",
            "Программно-аппаратные средства защиты информации",
            "Аппаратные средства вычислительной техники",
        ),
        imageUrl = "https://www.kstu.ru/servlet/contentblob?id=294760",
        bio = "В 2006 году с золотой медалью за особые успехи в учебе окончила среднюю общеобразовательную школу №5 (с углубленным изучением отдельных предметов) города Нижнекамска.\n" +
                "\n" +
                "В 2011 году с отличием окончила Нижнекамский химико-технологический институт (филиал) ФГБОУ ВПО «Казанский национальный исследовательский технологический университет» по специальности «Автоматизированные системы обработки информации и управления».\n" +
                "\n" +
                "В сентябре 2011 года поступила в аспирантуру ФГБОУ ВПО «Казанский национальный исследовательский технологический университет» на кафедру теоретических основ теплотехники под руководством профессора Гумерова Ф.М. 29 декабря 2015 года успешно защитила кандидатскую диссертацию на тему: «Исследование свойств термодинамических систем и процесса получения биодизельного топлива трансэтерификацией рапсового масла в среде этанола в сверхкритических флюидных условиях».",
    )

    val weekSchedule = listOf(
        ScheduleDayModel(
            dayOfWeek = "Пн",
            typeOfWeek = "Нечет",
            date = "07.10.2022",
            scheduleDayId = "Нечет/Пн",
            subjects = listOf(
                SubjectModel(
                    title = "Средства и системы технического обеспечения обработки, хранения и передачи информации",
                    shortTitle = "СИСТО",
                    type = "Лекция",
                    prepod = "Ильин Г.И.",
                    cabinet = "И-1-209",
                    duration = "1 сен - 1 янв",
                    subjectId = Random.nextInt(),
                    startTime = "11:20",
                    endTime = "12:50",
                    scheduleDayId = "Нечет/Ср",
                ),
                SubjectModel(
                    title = "Средства и системы технического обеспечения обработки, хранения и передачи информации",
                    shortTitle = "СИСТО",
                    type = "Лабораторная Работа",
                    prepod = "Ильин Г.И.",
                    cabinet = "И-1-204",
                    duration = "1 сен - 1 янв",
                    subjectId = Random.nextInt(),
                    startTime = "13:00",
                    endTime = "14:30",
                    scheduleDayId = "Нечет/Ср",
                ),
                SubjectModel(
                    title = "Теория вероятностей и математическая статистика",
                    shortTitle = "ТВИМС",
                    type = "Лекция",
                    prepod = "Хайруллин М.Х.",
                    cabinet = "Д-240",
                    duration = "1 сен - 1 янв",
                    subjectId = Random.nextInt(),
                    startTime = "16:20",
                    endTime = "17:50",
                    scheduleDayId = "Нечет/Ср",
                ),
                SubjectModel(
                    title = "Дискретная математика",
                    shortTitle = "ДМ",
                    type = "Лабораторная Работа",
                    prepod = "Климова А.С.",
                    cabinet = "Д-505",
                    duration = "1 сен - 1 янв",
                    subjectId = Random.nextInt(),
                    startTime = "18:00",
                    endTime = "19:30",
                    scheduleDayId = "Нечет/Ср",
                ),
            ),
        ),
        ScheduleDayModel(
            dayOfWeek = "Вт",
            typeOfWeek = "Нечет",
            scheduleDayId = "Нечет/Вт",
            date = "08.11.2022",
            subjects = listOf(
                SubjectModel(
                    scheduleDayId = "Нечет/Вт",
                    title = "Элективные курсы по физической культуре и спорту. Элективные курсы проходят в спортивном комплексе \"МИРАС\"",
                    shortTitle = "Физра",
                    type = "Практика",
                    prepod = "",
                    cabinet = "",
                    duration = "1 сен - 1 янв",
                    subjectId = Random.nextInt(),
                    startTime = "09:40",
                    endTime = "11:10",
                    scheduleDayId = "Нечет/Вт",
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
                    scheduleDayId = "Нечет/Ср",
                    title = "Средства и системы технического обеспечения обработки, хранения и передачи информации",
                    shortTitle = "СИСТО",
                    type = "Лекция",
                    prepod = "Ильин Г.И.",
                    cabinet = "И-1-209",
                    duration = "1 сен - 1 янв",
                    subjectId = Random.nextInt(),
                    startTime = "11:20",
                    endTime = "12:50",
                    scheduleDayId = "Нечет/Ср",
                ),
                SubjectModel(
                    scheduleDayId = "Нечет/Ср",
                    title = "Средства и системы технического обеспечения обработки, хранения и передачи информации",
                    shortTitle = "СИСТО",
                    type = "Лабораторная Работа",
                    prepod = "Ильин Г.И.",
                    cabinet = "И-1-204",
                    duration = "1 сен - 1 янв",
                    subjectId = Random.nextInt(),
                    startTime = "13:00",
                    endTime = "14:30",
                    scheduleDayId = "Нечет/Ср",
                ),
                SubjectModel(
                    scheduleDayId = "Нечет/Ср",
                    title = "Теория вероятностей и математическая статистика",
                    shortTitle = "ТВИМС",
                    type = "Лекция",
                    prepod = "Хайруллин М.Х.",
                    cabinet = "Д-240",
                    duration = "1 сен - 1 янв",
                    subjectId = Random.nextInt(),
                    startTime = "16:20",
                    endTime = "17:50",
                    scheduleDayId = "Нечет/Ср",
                ),
                SubjectModel(
                    scheduleDayId = "Нечет/Ср",
                    title = "Дискретная математика",
                    shortTitle = "ДМ",
                    type = "Лабораторная Работа",
                    prepod = "Климова А.С.",
                    cabinet = "Д-505",
                    duration = "1 сен - 1 янв",
                    subjectId = Random.nextInt(),
                    startTime = "18:00",
                    endTime = "19:30",
                    scheduleDayId = "Нечет/Ср",
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
                    scheduleDayId = "Нечет/Чт",
                    title = "Информационные технологии в информационной безопасности",
                    shortTitle = "ИТВИБ",
                    type = "Лабораторная Работа",
                    prepod = "Богомолов В.А.",
                    cabinet = "П-7",
                    duration = "1 сен - 4 дек",
                    subjectId = Random.nextInt(),
                    startTime = "09:40",
                    endTime = "11:10",
                    scheduleDayId = "Нечет/Чт",
                ),
                SubjectModel(
                    scheduleDayId = "Нечет/Чт",
                    title = "Информационные технологии в информационной безопасности",
                    shortTitle = "ИТВИБ",
                    type = "Лекция",
                    prepod = "Богомолов В.А.",
                    cabinet = "П-7",
                    duration = "1 сен - 4 дек",
                    subjectId = Random.nextInt(),
                    startTime = "11:20",
                    endTime = "12:50",
                    scheduleDayId = "Нечет/Чт",
                ),
                SubjectModel(
                    scheduleDayId = "Нечет/Чт",
                    title = "Основы информационной безопасности",
                    shortTitle = "ОИБ",
                    type = "Лабораторная Работа",
                    prepod = "Садыков А.М.",
                    cabinet = "И-1-204",
                    duration = "1 сен - 4 дек",
                    subjectId = Random.nextInt(),
                    startTime = "13:00",
                    endTime = "14:30",
                    scheduleDayId = "Нечет/Чт",
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
                    scheduleDayId = "Нечет/Пт",
                    title = "Элективные курсы по физической культуре и спорту. Элективные курсы проходят в спортивном комплексе \"МИРАС\"",
                    shortTitle = "Физра",
                    type = "Практика",
                    prepod = "",
                    cabinet = "",
                    duration = "1 сен - 1 янв",
                    subjectId = Random.nextInt(),
                    startTime = "13:00",
                    endTime = "14:30",
                    scheduleDayId = "Нечет/Пт",
                ),
                SubjectModel(
                    scheduleDayId = "Нечет/Пт",
                    title = "Теория вероятностей и математическая статистика",
                    shortTitle = "ТВИМС",
                    type = "Практика",
                    prepod = "Хайруллин М.Х.",
                    cabinet = "Д-104а",
                    duration = "31 окт - 1 янв",
                    subjectId = Random.nextInt(),
                    startTime = "16:20",
                    endTime = "17:50",
                    scheduleDayId = "Нечет/Пт",
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