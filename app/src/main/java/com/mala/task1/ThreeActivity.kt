package com.mala.task1

import android.content.Intent
import android.graphics.drawable.Icon
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mala.task1.databinding.ActivityThreeBinding
import com.squareup.picasso.Picasso

class ThreeActivity : AppCompatActivity() {
    lateinit var binding:ActivityThreeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)
     intent.getStringExtra("name")
        // convert image to drawable
       val imageUrl:String= intent.extras?.getString("image")?:""
        println("imagurl:$imageUrl")
        if(imageUrl.isNotEmpty()){

            Picasso.get().load(imageUrl).into(binding.threeImage)
        }
       binding.DateThree.text= intent.getStringExtra("date")
        binding.commentThree.text=intent.getStringExtra("comment")
    }
}