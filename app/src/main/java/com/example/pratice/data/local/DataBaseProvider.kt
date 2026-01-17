package com.example.pratice.data.local
import android.content.Context
import androidx.room.Room


object DatabaseProvider {
    fun getDatabase(context: Context): JokesDataBase =
        Room.databaseBuilder(
            context.applicationContext,
            JokesDataBase::class.java,
            "jokes_db"
        ).build()
}
