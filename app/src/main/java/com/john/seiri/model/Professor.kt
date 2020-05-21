package com.john.seiri.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Professor(
    @PrimaryKey val professorName: String,
    val email: String,
    val building: String,
    val room: String,
    val days: ArrayList<Int>,
    val timeStart: String,
    val timeEnd: String,
    val courseOwner: String
): Parcelable