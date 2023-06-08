package com.example.example

import com.google.gson.annotations.SerializedName


data class Hero (

  @SerializedName("name") var name: String? = null,
  @SerializedName("realname") var realname    : String? = null,
  @SerializedName("team") var team   : String? = null,
  @SerializedName("firstappearance") var firstappearance : String? = null,
  @SerializedName("createdby") var createdby   : String? = null,
  @SerializedName("publisher") var publisher : String? = null,
  @SerializedName("imageurl") var imageurl  : String? = null,
  @SerializedName("bio") var bio  : String? = null

)