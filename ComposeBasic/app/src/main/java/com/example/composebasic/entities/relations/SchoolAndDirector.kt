package com.example.composebasic.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.composebasic.entities.Director
import com.example.composebasic.entities.School

data class SchoolAndDirector(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"

    )

    val director: Director

)
