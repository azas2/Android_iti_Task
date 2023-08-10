package com.mala.task1.model

import retrofit2.Response
import retrofit2.http.GET

interface ApisInterfac {
    @GET("/api/users")
suspend fun getUser():Response<ResponseUsersList>
}