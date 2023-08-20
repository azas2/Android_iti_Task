package com.mala.task1.ui.Second


import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mala.task1.CoustemAdapter
import com.mala.task1.CoustemOnClickLisner
import com.mala.task1.R
import com.mala.task1.databinding.ActivitySecondBinding
import com.mala.task1.Core.data_source.remote.RetrofitClient
import com.mala.task1.Core.model.Post
import com.mala.task1.Core.rep.PostRepo
import com.mala.task1.ui.ThreeActivity
import com.mala.task1.ui.login.MainActivity
import retrofit2.Response


class SecondActivity : AppCompatActivity() , CoustemOnClickLisner {
    lateinit var binding: ActivitySecondBinding
    lateinit var postsAdapter: CoustemAdapter
    lateinit var pref: SharedPreferences
   val viewModel=SecondViewModel(PostRepo())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.logindata.observe(this){
            if(it.isSuccessful){
                postsAdapter = CoustemAdapter(it.body()?: ArrayList(),this@SecondActivity)
                binding.Recucler.layoutManager = LinearLayoutManager(this@SecondActivity)
                binding.Recucler.adapter = postsAdapter
            }
        }


        /*
        val Posts= arrayListOf(User("ahmed alaa","https://img.freepik.com/free-psd/3d-illustration-person-with-sunglasses_23-2149436200.jpg?w=740&t=st=1691499853~exp=1691500453~hmac=118b4391800e19b85254897e999ed6909896258242aadb652a058789c870f0cb","30 OCT2022","dont play with gradle"),
            User("MALA","https://img.freepik.com/free-psd/3d-illustration-person-with-glasses_23-2149436190.jpg?w=740&t=st=1691500894~exp=1691501494~hmac=dbff5cc81d21df7c9e931976d4fcaac0aa6882841be0a0688170a67cc434f7dc","30 NOV2022","dont play with gradle"),
            User("mido","https://img.freepik.com/free-psd/3d-illustration-person-tank-top_23-2149436202.jpg?w=740&t=st=1691500969~exp=1691501569~hmac=9d77437832c77bdb6c8f07115d1b822266de167ed0b6dc47a302686175debf60","9 JUN2022","dont play with gradle"),
            User("fouda","https://img.freepik.com/free-psd/3d-illustration-bald-person_23-2149436183.jpg?w=740&t=st=1691500990~exp=1691501590~hmac=38e05a6f5e05c9e5fdd6d7ae59cceb7880e4821c0b9f215129513b0c0903ea5f","5 NOV2020","dont play with gradle"),
            User("ALi","","30 NOV2022","dont play with gradle"))
                                    // her told this is var
*/
       binding.btnClick.setOnClickListener {
           viewModel.getPostById(binding.btn.text.toString().toInt())

       }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_activity_second, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.login -> {
                pref = applicationContext.getSharedPreferences("MySharedPreferences", MODE_PRIVATE)
                val editor = pref.edit()
                editor.apply()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
                true
            }
            else -> {

                return super.onOptionsItemSelected(item)
            }
        }
    }

  override fun onClickItem(post: Post, position: Int) {
     /*
            lifecycleScope.launchWhenCreated {

               val respone = retrofit.getComment(post.id)

                if (respone.isSuccessful) {
                    var comment = respone.body()?.get(0)

                    val intent = Intent(this@SecondActivity, ThreeActivity::class.java)
                    intent.putExtra("postId",comment?.postId)
                    intent.putExtra("commentId",comment?.id)
                    intent.putExtra("email", comment?.email)
                    intent.putExtra("name", comment?.name)
                    intent.putExtra("body", comment?.body)
                    startActivity(intent)


                } else {
                    Toast.makeText(this@SecondActivity, "Error", Toast.LENGTH_SHORT).show()
                }

            */
      }


  }


