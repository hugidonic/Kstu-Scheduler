package com.hugidonic.data.db.converters

import com.google.common.truth.Truth
import com.hugidonic.data.converters.toScheduleDayEntity
import com.hugidonic.data.converters.toScheduleDayModel
import com.hugidonic.data.database.entities.ScheduleDayEntity
import com.hugidonic.domain.models.ScheduleDayModel
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ScheduleConverterTest {
    @Test
    @DisplayName("Should convert from entity to Model")
    fun entityToScheduleDayModelConverter() {
        val entity = ScheduleDayEntity(
            dayOfWeek = "Пн",
            typeOfWeek = "Нечет",
            date = "09.11.2020"
        )

        val model = entity.toScheduleDayModel()
        Truth.assertThat(model.date).isEqualTo("09.11.2020")
        Truth.assertThat(model.typeOfWeek).isEqualTo("Нечет")
        Truth.assertThat(model.dayOfWeek).isEqualTo("Пн")
    }

    @Test
    @DisplayName("Should convert from dto to Entity")
    fun dtoToScheduleDayEntityConverter() {
        val dto = ScheduleDayModel(
            dayOfWeek = "Ср",
            typeOfWeek = "Нечет",
            date = "09.11.2020"
        )

        val entity = dto.toScheduleDayEntity()

        Truth.assertThat(entity.date).isEqualTo("09.11.2020")
        Truth.assertThat(entity.typeOfWeek).isEqualTo("Нечет")
        Truth.assertThat(entity.dayOfWeek.toString()).isEqualTo("Ср")
    }
}