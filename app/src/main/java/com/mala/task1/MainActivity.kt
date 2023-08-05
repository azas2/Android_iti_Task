package com.mala.task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mala.task1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    fun checkfix(check: String): String {
        if (check == "Female") {
            return "Ms, "
        } else
            return "Mr, "
    }
    fun giveSports(check: String):String{
        val sports = check.split("\n")
        val sportsString = StringBuilder()
        for (sport in sports) {
            sportsString.append("$sport")
        }
        return sportsString.toString()
    }
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val userName = binding.usernameEd.text

            lateinit var checkGender: String
            var checkSports: String=""
            // check of sport
            binding.Football.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked)
                    checkSports += "Football \n"
            }
            binding.basketball.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked)
                    checkSports += "basketball \n"
            }
            binding.valleyball.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked)
                    checkSports += "valleyball"
            }
            binding.Female.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked)
                    checkGender = "Female"
            }
            binding.Male.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked)
                    checkGender = "male"
            }




            binding.btnLog.setOnClickListener {
                val sportChose= giveSports(checkSports)
                val toShow="Welcome ${checkfix(checkGender)} ${userName.toString()}, your favorite sports are:\n$sportChose and your gender is $checkGender"
                Toast.makeText(this, toShow, Toast.LENGTH_LONG).show()
            }
    }
}