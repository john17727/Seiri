package com.john.seiri.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Course(
    @PrimaryKey val courseName: String,
    val building: String,
    val room: String,
    val days: ArrayList<Int>,
    val timeStart: String,
    val timeEnd: String,
    val color: Int
): Parcelable