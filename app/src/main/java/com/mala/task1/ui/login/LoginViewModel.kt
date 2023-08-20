package com.mala.task1.ui.login

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mala.task1.Core.model.body.LoginBack
import com.mala.task1.Core.model.respons.UserRespon
import com.mala.task1.Core.rep.LoginRepo
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel:ViewModel() {
    var logindata:MutableLiveData<Response<UserRespon>> = MutableLiveData()
    val rep=LoginRepo()
    lateinit var pref : SharedPreferences
      fun startLogin(username:String,password:String,context:Context){
          pref=context.getSharedPreferences("MySharedPreferences", AppCompatActivity.MODE_PRIVATE)
          val editor=pref.edit()
          editor.putString("user ",username)
          editor.putString("Password ",password)
          editor.putBoolean("LogIn",true)
          editor.commit()
          viewModelScope.launch {
              logindata.postValue(rep.login(username,password))
          }
    }

}