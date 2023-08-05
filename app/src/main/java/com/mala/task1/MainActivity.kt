package com.mala.task1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mala.task1.databinding.ActivityMainBinding

enum class  NAMES(){
    FOOTBALL,BASKETBALL,VALLEYbBALL,FEMALE,MALE
}
class MainActivity : AppCompatActivity() {
    fun checkfix(check: String): String {
        if (check == "Female") {
            return "Ms, "
        } else
            return "Mr, "
    }

    fun giveSports(check: String): String {
        val sports = check.split("\n")
        val sportsString = StringBuilder()
        for (sport in sports) {
            sportsString.append("$sport")
        }
        return sportsString.toString()
    }
    val REQUST_CODE=1
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val userName = binding.usernameEd.text
        lateinit var checkGender: String
        var checkSports: String = ""

        // check of sport
        binding.Football.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked)
                checkSports += "${NAMES.FOOTBALL.name} \n"
        }
        binding.basketball.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked)
                checkSports += "${NAMES.BASKETBALL.name} \n"
        }
        binding.valleyball.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked)
                checkSports += "${NAMES.VALLEYbBALL.name}"
        }
        binding.Female.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked)
                checkGender = "${NAMES.FEMALE.name}"
        }
        binding.Male.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked)
                checkGender = "${NAMES.MALE.name}"
        }


        binding.btnLog.setOnClickListener {
            val intent =Intent(this,SecondActivity::class.java)
           startActivityForResult(intent,REQUST_CODE)
           val sportChose = giveSports(checkSports)
            val toShow = "Welcome ${checkfix(checkGender)} ${userName.toString()}, your favorite sports are:\n$sportChose and your gender is $checkGender"
            Toast.makeText(this, toShow, Toast.LENGTH_LONG).show()
        }

    }
    // RESULT BACK FROM SecondActivity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUST_CODE) {
            if (resultCode == 1) {
                Toast.makeText(this, "login by Google", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "login by Facebook", Toast.LENGTH_LONG).show()
            }
        }
    }
}