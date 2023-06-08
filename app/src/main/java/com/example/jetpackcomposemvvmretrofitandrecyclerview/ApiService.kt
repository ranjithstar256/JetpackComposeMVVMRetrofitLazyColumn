package com.example.jetpackcomposemvvmretrofitandrecyclerview

import com.example.example.Hero
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("random?number=30&instructionsRequired=true/apiKey=ab7c4562165841f88f6e00c1529ae6b2")
    //@GET("top-headlines?country=us&category=business&apiKey=684cb893caf7425abeffad82ac1d0f4e")
    ///@GET("search?q=chatgpt")

    //https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=684cb893caf7425abeffad82ac1d0f4e
        suspend fun getMovies() :WholeData

    companion object {
        var apiService: ApiService? = null
        fun getInstance() : ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                   // .baseUrl("https://howtodoandroid.com/apis/")
                   // .baseUrl("https://newsapi.org/v2/")
                  //  .baseUrl("https://simplifiedcoding.net/demos/")
                    //.baseUrl("https://podcast-episodes.p.rapidapi.com/")

                    .baseUrl("https://api.spoonacular.com/recipes/")

                    .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }

}