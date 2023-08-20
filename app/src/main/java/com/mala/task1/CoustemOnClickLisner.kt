package com.mala.task1

import com.mala.task1.Core.model.Post

interface CoustemOnClickLisner {
    fun onClickItem(post: Post, position: Int)
}