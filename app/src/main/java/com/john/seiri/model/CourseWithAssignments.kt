package com.john.seiri.model

import androidx.room.Embedded
import androidx.room.Relation

data class CourseWithAssignments(
    @Embedded val course: Course,
    @Relation(
        parentColumn = "courseName",
        entityColumn = "courseOwner"
    )
    val assignments: ArrayList<Assignment>
)