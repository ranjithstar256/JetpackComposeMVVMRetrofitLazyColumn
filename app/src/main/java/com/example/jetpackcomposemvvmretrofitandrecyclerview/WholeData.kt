package com.example.jetpackcomposemvvmretrofitandrecyclerview

import com.google.gson.annotations.SerializedName


data class WholeData (

    @SerializedName("recipes" ) var recipes : ArrayList<Recipes> = arrayListOf()

)