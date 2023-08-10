package com.mala.task1


import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mala.task1.databinding.ActivityMainBinding
import com.mala.task1.databinding.ActivitySecondBinding
import com.mala.task1.model.ApisInterfac
import com.mala.task1.model.RetrofitClient
import com.mala.task1.model.User


class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    lateinit var UserAdapter: CoustemAdapter
    lateinit var  pref:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*
        val Posts= arrayListOf(User("ahmed alaa","https://img.freepik.com/free-psd/3d-illustration-person-with-sunglasses_23-2149436200.jpg?w=740&t=st=1691499853~exp=1691500453~hmac=118b4391800e19b85254897e999ed6909896258242aadb652a058789c870f0cb","30 OCT2022","dont play with gradle"),
            User("MALA","https://img.freepik.com/free-psd/3d-illustration-person-with-glasses_23-2149436190.jpg?w=740&t=st=1691500894~exp=1691501494~hmac=dbff5cc81d21df7c9e931976d4fcaac0aa6882841be0a0688170a67cc434f7dc","30 NOV2022","dont play with gradle"),
            User("mido","https://img.freepik.com/free-psd/3d-illustration-person-tank-top_23-2149436202.jpg?w=740&t=st=1691500969~exp=1691501569~hmac=9d77437832c77bdb6c8f07115d1b822266de167ed0b6dc47a302686175debf60","9 JUN2022","dont play with gradle"),
            User("fouda","https://img.freepik.com/free-psd/3d-illustration-bald-person_23-2149436183.jpg?w=740&t=st=1691500990~exp=1691501590~hmac=38e05a6f5e05c9e5fdd6d7ae59cceb7880e4821c0b9f215129513b0c0903ea5f","5 NOV2020","dont play with gradle"),
            User("ALi","","30 NOV2022","dont play with gradle"))
                                    // her told this is var
*/

        binding.Recucler.layoutManager=LinearLayoutManager(this)
        var retrofit=RetrofitClient.getInstance().create(ApisInterfac::class.java)
        lifecycleScope.launchWhenCreated {
            var respon=retrofit.getUser()
            if(respon.isSuccessful){
                UserAdapter= CoustemAdapter(respon.body()?.data ?: listOf())
                binding.Recucler.adapter=UserAdapter
                Toast.makeText(this@SecondActivity,respon.body()?.data?.get(0)?.email?:"not found",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this@SecondActivity,"Error",Toast.LENGTH_SHORT).show()
            }
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_activity_second,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.login -> {
                pref=applicationContext.getSharedPreferences("MySharedPreferences",MODE_PRIVATE)
                val editor=pref.edit()
                editor.apply()
              startActivity(Intent(this,MainActivity::class.java))
                finish()
                true
            }
            else->{

             return super.onOptionsItemSelected(item)
            }
        }
    }
/*
    override fun onClickItem(post: User, position: Int) {
      val intent= Intent(this,ThreeActivity::class.java)
        intent.putExtra("name",post.name)
        intent.putExtra("image",post.urlImage)
        intent.putExtra("date",post.date)
        intent.putExtra("comment",post.comment)
            startActivity(intent)
*/
    }

