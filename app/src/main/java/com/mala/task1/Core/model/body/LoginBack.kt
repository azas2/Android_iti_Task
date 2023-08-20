package com.mala.task1.Core.model.body

import com.google.gson.annotations.SerializedName

data class LoginBack(
     @SerializedName("username")
     val username:String,
     @SerializedName("password")
     val password:String
     ) {
}