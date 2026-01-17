package com.example.pratice.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pratice.data.local.JokesDataModel
import com.example.pratice.data.repo.JokesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class JokesViewModel(
    private val repository: JokesRepository
) : ViewModel() {

    // Just expose Room Flow
    val jokes: Flow<List<JokesDataModel>> = repository.getJokesFromDb()

    // Fetch API and store in Room
    fun loadJokes() {
        viewModelScope.launch {
            repository.fetchAndStoreJokes()
        }
    }
}
