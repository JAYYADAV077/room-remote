package com.example.pratice.data.repo

import com.example.pratice.data.local.JokesDao
import com.example.pratice.data.local.JokesDataModel
import com.example.pratice.data.remote.JokeApi

class JokesRepository(
    private val api: JokeApi,
    private val dao: JokesDao
) {

    suspend fun fetchAndStoreJokes() {
        val jokesFromApi = api.getJokes()

        // map API model → Room entity
        val entities = jokesFromApi.map {
            JokesDataModel(
                punchline = it.punchline,
                setup = it.setup,
                type = it.type
            )
        }

        dao.insertJokes(entities)
    }

    fun getJokesFromDb() = dao.getJokes()
}
