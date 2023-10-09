package com.example.composebasic.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.composebasic.entities.Subject

data class StudentWithSubjects (
    @Embedded
    val student: String,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects: List<Subject>
    )

