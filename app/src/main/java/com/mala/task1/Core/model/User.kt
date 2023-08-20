package com.mala.task1.Core.model

import com.google.gson.annotations.SerializedName

data class User (
     @SerializedName("id")
     var id:Int,
     @SerializedName("firstname")
     var firstname:String,
     @SerializedName("lastname")
     var lastName:String,
     @SerializedName("email")
     var email:String,
     @SerializedName("avatar")
     var avatar:String)