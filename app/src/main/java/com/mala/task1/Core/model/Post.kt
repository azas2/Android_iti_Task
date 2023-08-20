package com.mala.task1.Core.model

import com.google.gson.annotations.SerializedName

data class Post (
    @SerializedName("userId")
    var userid:Int,
    @SerializedName("id")
    var id:Int,
    @SerializedName("title")
    var title:String,
    @SerializedName("body")
    var body: String
)