package com.hugidonic.domain.models

data class PrepodDetailsModel (
    val info: String,
    val imageUrl: String,
    val subjects_taught: List<String>,
    val bio: String
)
