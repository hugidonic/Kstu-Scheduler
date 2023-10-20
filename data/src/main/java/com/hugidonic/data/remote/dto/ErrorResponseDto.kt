package com.hugidonic.data.remote.dto

data class ErrorDetailDto(
    val message: String
)

data class ErrorResponseDto(
    val detail: ErrorDetailDto
)