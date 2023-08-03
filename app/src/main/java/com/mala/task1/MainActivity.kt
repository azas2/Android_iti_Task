package com.mala.task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mala.task1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    fun checkfix(check:String):String{
        if (check=="Female"){
            return "Ms, "
        }
        else
            return "Mr, "
    }
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val userName=binding.usernameEd.text
       lateinit var checkSport:String
        lateinit var checkGender:String

       // check of sport
        binding.Football.setOnCheckedChangeListener{  buttonView, isChecked ->
            if(isChecked)
                checkSport="Football"
        }
        binding.basketball.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked)
                checkSport="basktball"
        }
        binding.valleyball.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked)
                checkSport="valleyball"
        }
        binding.Female.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked)
                checkGender="Female"
        }
        binding.Male.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked)
                checkGender="male"
        }




binding.btnLog.setOnClickListener{
    Toast.makeText(baseContext, "welcom ${checkfix(checkGender)}${userName.toString()},your favourite sport is $checkSport and your Gender is $checkGender ", Toast.LENGTH_LONG).show()
}


    }
}