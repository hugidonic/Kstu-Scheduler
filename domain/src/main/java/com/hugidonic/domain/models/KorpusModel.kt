package com.hugidonic.domain.models

data class KorpusModel(
    /** Широта **/
    val latitude: Double,
    /** Долгота **/
    val longitude: Double,
) {
    fun getMap(): String = "$longitude,$latitude"
    fun getYandexMapMarchrute(): String = "$latitude,$longitude"
}