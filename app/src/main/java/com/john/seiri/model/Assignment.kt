package com.john.seiri.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Assignment(
    @PrimaryKey(autoGenerate = true) val assignmentId: Int,
    val title: String,
    val dueDate: String,
    val type: String,
    val notes: String,
    val courseOwner: String
)