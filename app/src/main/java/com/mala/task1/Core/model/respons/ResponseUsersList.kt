package com.mala.task1.Core.model.respons

import com.google.gson.annotations.SerializedName
import com.mala.task1.Core.model.Support
import com.mala.task1.Core.model.User

data class ResponseUsersList (
    @SerializedName("page")
    var pag:Int,
    @SerializedName("per_page")
    var per_page:Int,
    @SerializedName("total")
    var total:Int,
    @SerializedName("total_pages")
    var total_pages:Int,
    @SerializedName("data")
    var data:List<User>,
    @SerializedName("support")
    var support: Support
    )