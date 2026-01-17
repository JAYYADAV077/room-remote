package com.example.pratice.data.remote

import com.example.pratice.data.remote.datamodel.JokeItem
import retrofit2.Response
import retrofit2.http.GET

interface JokeApi {

    @GET("random_ten")
    suspend fun getJokes(): List<JokeItem>
}