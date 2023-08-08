package com.mala.task1
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.mala.task1.databinding.ActivityMainBinding

enum class NAMES(){
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
            startActivity(intent)
            val sportChose = giveSports(checkSports)
         var toShow = "Welcome ${checkfix(checkGender)} ${userName.toString()}, your favorite sports are:\n$sportChose and your gender is $checkGender"
            Toast.makeText(this, toShow, Toast.LENGTH_LONG).show()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_activity_main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.exist ->{
                val dialog:AlertDialog.Builder=AlertDialog.Builder(this)
                dialog.setTitle(getString(R.string.to_exit))
                dialog.setCancelable(false)
                dialog.setPositiveButton("Ok",DialogInterface.OnClickListener { dialog, which ->
                    finish()
                })
                dialog.setNegativeButton("No",DialogInterface.OnClickListener { dialog, which ->
                })
                val alertDialog: AlertDialog = dialog.create()
                alertDialog.show()
                true
            }
            R.id.menu_show_Second -> {
                startActivity(Intent(this,SecondActivity::class.java))
                true
            }
            else ->
                super.onOptionsItemSelected(item)

        }
    }



}