package com.mala.task1.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mala.task1.databinding.ActivitySplashScreenBinding
import com.mala.task1.ui.Second.SecondActivity
import com.mala.task1.ui.login.MainActivity

class SplashScreenActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // hide appbar
        supportActionBar?.hide()
        android.os.Handler().postDelayed(Runnable {

            val pref=applicationContext.getSharedPreferences("MySharedPreferences",MODE_PRIVATE)
            val isLogin=pref.getBoolean("LogIn",false)
           if(isLogin==true){
               startActivity(Intent(this, SecondActivity::class.java))
           }
            else{
               startActivity(Intent(this, MainActivity::class.java))

           }
            finish()

        },3000)



    }
}