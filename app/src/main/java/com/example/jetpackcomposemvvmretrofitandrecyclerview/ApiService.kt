package com.example.jetpackcomposemvvmretrofitandrecyclerview


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface AbcAPIServc {

     //@Get = you just get something//  @Post you are passing some
    // parameter or some data to server // login



    @GET("top-headlines?country=us&category=business&apiKey=684cb893caf7425abeffad82ac1d0f4e")


    ///@GET("search?q=chatgpt")
    //https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=684cb893caf7425abeffad82ac1d0f4e
   // @GET("marvel")


    suspend fun getMovies() : News

    companion object {
        var apiService: AbcAPIServc? = null
        fun getInstance() : AbcAPIServc {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                   // .baseUrl("https://howtodoandroid.com/apis/")
                    .baseUrl("https://newsapi.org/v2/")
                   // .baseUrl("https://simplifiedcoding.net/demos/")
                    //.baseUrl("https://podcast-episodes.p.rapidapi.com/")

                    .addConverterFactory(GsonConverterFactory.create())
                .build().create(AbcAPIServc::class.java)
            }
            return apiService!!
        }
    }
}