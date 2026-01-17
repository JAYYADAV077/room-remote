package com.example.pratice.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jokes")
data class JokesDataModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val punchline: String,
    val setup: String,
    val type: String
)
