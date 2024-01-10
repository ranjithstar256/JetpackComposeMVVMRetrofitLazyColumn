package com.example.jetpackcomposemvvmretrofitandrecyclerview

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.example.Articles
import com.example.example.Hero
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {


    var movieListResponse:List<Hero> by mutableStateOf(listOf())

    var errorMessage: String by mutableStateOf("")
    var result: KLOCAPI by mutableStateOf(KLOCAPI())


    fun getMovieList() {
        viewModelScope.launch {

            val apiService = AbcAPIServc.getInstance()
            try {
                //movieListResponse= apiService.getMovies()
                result= apiService.getMovies()
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
            }

        }
    }
}