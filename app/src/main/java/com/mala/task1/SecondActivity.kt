package com.mala.task1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mala.task1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.SecondACBtnLogin.setOnClickListener{
            val intent= Intent()
            var RESULT_CODE:Int=if( binding.SecondACGoogle.isChecked)1 else 2
            setResult(RESULT_CODE,intent)
            finish()
        }


    }
}