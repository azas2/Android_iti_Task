package com.mala.task1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mala.task1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity(),CoustemOnClickLisner {
    lateinit var binding: ActivitySecondBinding
    lateinit var UserAdapter: CoustemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val Posts= arrayListOf(Post("ahmed alaa","https://img.freepik.com/free-psd/3d-illustration-person-with-sunglasses_23-2149436200.jpg?w=740&t=st=1691499853~exp=1691500453~hmac=118b4391800e19b85254897e999ed6909896258242aadb652a058789c870f0cb","30 OCT2022","dont play with gradle"),
            Post("MALA","https://img.freepik.com/free-psd/3d-illustration-person-with-glasses_23-2149436190.jpg?w=740&t=st=1691500894~exp=1691501494~hmac=dbff5cc81d21df7c9e931976d4fcaac0aa6882841be0a0688170a67cc434f7dc","30 NOV2022","dont play with gradle"),
            Post("mido","https://img.freepik.com/free-psd/3d-illustration-person-tank-top_23-2149436202.jpg?w=740&t=st=1691500969~exp=1691501569~hmac=9d77437832c77bdb6c8f07115d1b822266de167ed0b6dc47a302686175debf60","9 JUN2022","dont play with gradle"),
            Post("fouda","https://img.freepik.com/free-psd/3d-illustration-bald-person_23-2149436183.jpg?w=740&t=st=1691500990~exp=1691501590~hmac=38e05a6f5e05c9e5fdd6d7ae59cceb7880e4821c0b9f215129513b0c0903ea5f","5 NOV2020","dont play with gradle"),
            Post("ALi","","30 NOV2022","dont play with gradle"))
                                    // her told this is var
        UserAdapter= CoustemAdapter(Posts,this)
        binding.Recucler.adapter=UserAdapter
        binding.Recucler.layoutManager=LinearLayoutManager(this)

    }

    override fun onClickItem(post: Post, position: Int) {
      val intent= Intent(this,ThreeActivity::class.java)
        intent.putExtra("name",post.name)
        intent.putExtra("image",post.urlImage)
        intent.putExtra("date",post.date)
        intent.putExtra("comment",post.comment)
            startActivity(intent)

    }
}