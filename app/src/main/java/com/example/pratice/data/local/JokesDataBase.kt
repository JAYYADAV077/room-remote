package com.example.pratice.data.local

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [JokesDataModel::class],
    version = 1
)
abstract class JokesDataBase: RoomDatabase() {

    abstract fun getDao(): JokesDao
}