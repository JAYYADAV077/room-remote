package com.example.pratice.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface JokesDao {

    @Insert
   suspend fun insertJokes(jokes: List<JokesDataModel>)

    @Query("SELECT * FROM jokes")
    fun getJokes(): Flow<List<JokesDataModel>>
}