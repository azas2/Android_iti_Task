package com.mala.task1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mala.task1.databinding.ActivityThreeBinding

class ThreeActivity : AppCompatActivity() {
    lateinit var binding:ActivityThreeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)

      binding.Postid.text=intent.extras?.getInt("postId",0).toString()
      binding.commentIdTv.text=  intent.extras?.getInt("commentId",0).toString()
       binding.email.text= intent.extras?.getString("email","error")
       binding.comment.text= intent.extras?.getString("name", "error")
        binding.commentTv.text=intent.extras?.getString("body","error")
    }
}