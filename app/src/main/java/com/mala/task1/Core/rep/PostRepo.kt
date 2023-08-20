package com.mala.task1.Core.rep

import com.mala.task1.Core.data_source.remote.RetrofitClient
import com.mala.task1.Core.model.Post
import retrofit2.Response

class PostRepo {
    val retrofit = RetrofitClient.getInstance("https://jsonplaceholder.typicode.com/")
    suspend fun getPost(): Response<ArrayList<Post>> {
        return retrofit.getposts()
    }

    suspend fun getPostById(userId: Int): Response<ArrayList<Post>> {
        return retrofit.getPostByUser(userId)
    }
}