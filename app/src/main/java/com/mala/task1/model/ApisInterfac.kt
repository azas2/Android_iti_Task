package com.mala.task1.model

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApisInterfac {
    @GET("posts")
suspend fun getposts():Response<ArrayList<Post>>
    @GET("posts")
suspend fun getPostByUser(@Query("userId") userId:Int):Response<ArrayList<Post>>
@GET("posts/")
suspend fun getComment(postId:Int):Response<ArrayList<Comment>>
}