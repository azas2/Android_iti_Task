package com.mala.task1.Core.model.respons

import com.google.gson.annotations.SerializedName

data class UserRespon (
     @SerializedName("id")
     val id:Int,
     @SerializedName("username")
     val username:String,
     @SerializedName("email")
     val email:String,
     @SerializedName("firstname")
     val firstname:String,
     @SerializedName("lastname")
     val lastname:String,
     @SerializedName("gender")
     val gender:String,
     @SerializedName("image")
     val image:String,
     @SerializedName("token")
     val token:String

         ){

 }