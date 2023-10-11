package com.example.jetpackcomposemvvmretrofitandrecyclerview

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.example.Articles
import com.example.example.Hero
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {


    var movieListResponse:List<Articles> by mutableStateOf(listOf())

    var errorMessage: String by mutableStateOf("")

    fun getMovieList() {
        viewModelScope.launch {

            val apiService = ApiService.getInstance()
            try {
                movieListResponse= apiService.getMovies().articles
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
            }

        }
    }
}