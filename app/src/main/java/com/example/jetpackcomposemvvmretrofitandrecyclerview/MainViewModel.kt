package com.example.jetpackcomposemvvmretrofitandrecyclerview

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    var movieListResponse:List<News> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")
    fun getMovieList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val movieList = apiService.getMovies()
                movieListResponse = listOf(movieList)
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
                Log.i("adfsfdsdf", "getMovieList: "+errorMessage)
            }
        }
    }
}