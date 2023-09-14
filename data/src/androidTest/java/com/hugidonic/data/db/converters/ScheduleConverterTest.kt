package com.hugidonic.data.db.converters

import com.google.common.truth.Truth
import com.hugidonic.data.converters.toModel
import com.hugidonic.data.converters.toScheduleDayEntity
import com.hugidonic.data.database.entities.ScheduleDayEntity
import com.hugidonic.data.database.entities.relations.ScheduleDayWithSubjects
import com.hugidonic.data.remote.dto.ScheduleDayDto
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ScheduleConverterTest {
    @Test
    @DisplayName("Should convert from entity to Model")
    fun entityToScheduleDayModelConverter() {
        val entity = ScheduleDayWithSubjects(
            scheduleDayInfo = ScheduleDayEntity(
                dayOfWeek = "Пн",
                typeOfWeek = "Нечет",
                date = "09.11.2020",
                scheduleDayId = "Нечет/Пн"
            ),
            subjects = emptyList()
        )

        val model = entity.toModel()
        Truth.assertThat(model.date).isEqualTo("09.11.2020")
        Truth.assertThat(model.typeOfWeek).isEqualTo("Нечет")
        Truth.assertThat(model.dayOfWeek).isEqualTo("Пн")
        Truth.assertThat(model.scheduleDayId)
            .isEqualTo("${entity.scheduleDayInfo.typeOfWeek}/${entity.scheduleDayInfo.dayOfWeek}")
    }

    @Test
    @DisplayName("Should convert from dto to Entity")
    fun dtoToScheduleDayEntityConverter() {
        val dto = ScheduleDayDto(
            dayOfWeek = "Ср",
            typeOfWeek = "Нечет",
            date = "09.11.2020",
            subjects = emptyList()
        )

        val entity = dto.toScheduleDayEntity()

        Truth.assertThat(entity.date).isEqualTo("09.11.2020")
        Truth.assertThat(entity.typeOfWeek).isEqualTo("Нечет")
        Truth.assertThat(entity.dayOfWeek).isEqualTo("Ср")
        Truth.assertThat(entity.scheduleDayId).isEqualTo("${dto.typeOfWeek}/${dto.dayOfWeek}")
    }
}