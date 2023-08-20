package com.mala.task1.Core.rep

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import com.mala.task1.Core.data_source.remote.RetrofitClient
import com.mala.task1.Core.model.body.LoginBack
import com.mala.task1.Core.model.respons.UserRespon
import retrofit2.Response
import retrofit2.Retrofit

class LoginRepo {
    val retrofit=RetrofitClient.getInstance("https://dummyjson.com/")

  suspend  fun login(username:String,password:String):Response<UserRespon>{

      return  retrofit.login(LoginBack(username,password))
    }
}