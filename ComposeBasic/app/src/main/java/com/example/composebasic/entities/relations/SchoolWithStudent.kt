package com.example.composebasic.entities.relations


import androidx.room.Embedded
import androidx.room.Relation
import com.example.composebasic.entities.School
import com.example.composebasic.entities.Student

data class SchoolWithStudent(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val student: List<Student>
)
