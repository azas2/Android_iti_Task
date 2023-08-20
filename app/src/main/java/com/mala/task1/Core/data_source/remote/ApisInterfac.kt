package com.mala.task1.Core.data_source.remote

import com.mala.task1.Core.model.Comment
import com.mala.task1.Core.model.body.LoginBack
import com.mala.task1.Core.model.Post
import com.mala.task1.Core.model.respons.UserRespon
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApisInterfac {
    @GET("posts")
suspend fun getposts():Response<ArrayList<Post>>
    @GET("posts")
suspend fun getPostByUser(@Query("userId") userId:Int):Response<ArrayList<Post>>
@GET("posts/")
suspend fun getComment(postId:Int):Response<ArrayList<Comment>>

@POST("auth/login")
 suspend fun login(@Body body: LoginBack): Response<UserRespon>    //here will return object
}