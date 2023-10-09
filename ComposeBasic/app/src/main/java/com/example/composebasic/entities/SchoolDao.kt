package com.example.composebasic.entities

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.composebasic.entities.relations.SchoolAndDirector
import com.example.composebasic.entities.relations.SchoolWithStudent
import com.example.composebasic.entities.relations.StudentSubjectCrossRef

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStdSubCrossRef(subject: StudentSubjectCrossRef)



    @Transaction
    @Query("SELECT * FROM school WHERE schoolName= :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String):List<SchoolAndDirector>

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName= :schoolName")
    suspend fun getStudentsWithSchoolName(schoolName: String):List<SchoolWithStudent>

    @Transaction
    @Query("SELECT * FROM subject WHERE subjectName= :subjectName")
    suspend fun getSubjectsWithStudents(subjectName: String):List<SchoolWithStudent>

    @Transaction
    @Query("SELECT * FROM student WHERE schoolName= :studentName")
    suspend fun getStudentsWithSubject(studentName: String):List<SchoolWithStudent>
}