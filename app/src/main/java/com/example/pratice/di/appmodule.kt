package com.example.pratice.di

import androidx.room.Room
import com.example.pratice.data.local.JokesDao
import com.example.pratice.data.local.JokesDataBase
import com.example.pratice.data.remote.JokeApi
import com.example.pratice.data.repo.JokesRepository
import com.example.pratice.presentation.JokesViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    /* ---------- NETWORK ---------- */

    // Retrofit
    single {
        Retrofit.Builder()
            .baseUrl("https://official-joke-api.appspot.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // API
    single<JokeApi> {
        get<Retrofit>().create(JokeApi::class.java)
    }

    /* ---------- DATABASE ---------- */

    // Room Database
    single<JokesDataBase> {
        Room.databaseBuilder(
            androidContext(),
            JokesDataBase::class.java,
            "jokes_db"
        ).build()
    }

    // DAO
    single<JokesDao> {
        get<JokesDataBase>().getDao()
    }

    /* ---------- REPOSITORY ---------- */

    single<JokesRepository> {
        JokesRepository(
            api = get(),
            dao = get()
        )
    }

    /* ---------- VIEWMODEL ---------- */

    viewModel {
        JokesViewModel(
            repository = get()
        )
    }
}
