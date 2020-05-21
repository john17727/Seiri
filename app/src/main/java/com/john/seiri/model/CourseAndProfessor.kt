package com.john.seiri.model

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Relation
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CourseAndProfessor(
    @Embedded val course: Course,
    @Relation(
        parentColumn = "courseName",
        entityColumn = "courseOwner"
    )
    val professor: Professor
) : Parcelable