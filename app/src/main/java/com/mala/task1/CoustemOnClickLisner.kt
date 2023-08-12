package com.mala.task1

import com.mala.task1.model.Post
import com.mala.task1.model.User

interface CoustemOnClickLisner {
    fun onClickItem(post: Post, position: Int)
}