package com.mala.task1.ui.Second

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mala.task1.Core.model.Post
import com.mala.task1.Core.model.respons.UserRespon
import com.mala.task1.Core.rep.PostRepo
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception

class SecondViewModel(val repo: PostRepo) : ViewModel() {
    var logindata: MutableLiveData<Response<ArrayList<Post>>> = MutableLiveData()

    init {
        getPosts()
    }

    fun getPosts() {
        viewModelScope.launch {

            try {
                val respons = repo.getPost()
                logindata.value = respons
            } catch (E: Exception) {
                println(E.message.toString())
            }
        }

    }

    fun getPostById(id: Int) {
        viewModelScope.launch {
            try {
                val respons = repo.getPostById(id)
                logindata.value = respons
            }
            catch (E:Exception){
                println(E.message.toString())
            }
        }

    }

}