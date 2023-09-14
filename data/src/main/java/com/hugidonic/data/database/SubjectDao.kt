package com.hugidonic.data.database

import androidx.room.*
import com.hugidonic.data.database.entities.SubjectEntity

@Dao
interface SubjectDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subjectEntity: SubjectEntity)

    @Transaction
    suspend fun insertListOfSubjects(subjectsEntities: List<SubjectEntity>) {
        subjectsEntities.forEach { insertSubject(it) }
    }

    @Query("SELECT * FROM subject")
    suspend fun getAllSubjects(): List<SubjectEntity>

    @Query("DELETE FROM subject")
    suspend fun clearSubjectTable()

    @Query("SELECT * FROM subject WHERE subjectTitle = :subjectTitle LIMIT 1")
    suspend fun getSubjectByTitle(subjectTitle: String): SubjectEntity

    @Query(
        """
		SELECT * FROM subject 
		WHERE LOWER(subjectTitle) LIKE '%' || LOWER(:query) || '%' OR UPPER(:query) == shortTitle
		LIMIT 1
	"""
    )
    suspend fun searchSubject(query: String): SubjectEntity
}