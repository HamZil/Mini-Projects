package com.example.composebasic.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.composebasic.entities.Student

data class SubjectWithStudents(
    @Embedded val subject: String,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val Students: List<Student>

)
