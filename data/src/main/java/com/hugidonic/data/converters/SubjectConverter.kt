package com.hugidonic.data.converters

import com.hugidonic.data.database.entities.SubjectEntity
import com.hugidonic.domain.models.SubjectModel

fun SubjectModel.toSubjectEntity(): SubjectEntity = SubjectEntity(
    subjectTitle = subjectTitle,
    typeOfSubject = typeOfSubject,
    prepod = prepod,
    shortTitle = shortTitle,
    cabinet = cabinet,
    date = date,
)

fun SubjectEntity.toSubjectModel(): SubjectModel = SubjectModel(
    subjectTitle = subjectTitle,
    typeOfSubject = typeOfSubject,
    prepod = prepod,
    shortTitle = shortTitle,
    cabinet = cabinet,
    date = date,
)