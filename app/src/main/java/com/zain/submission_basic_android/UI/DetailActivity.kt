package com.zain.submission_basic_android.UI

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.zain.submission_basic_android.DataClass.ValorantAgent
import com.zain.submission_basic_android.R
import com.zain.submission_basic_android.databinding.ActivityDetailBinding
import java.io.File

class DetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val actionbar = supportActionBar
        actionbar!!.title = "Detail Agent"

        getDataWithParcel()
        favClick()
        shareClick()



    }

    fun getDataWithParcel(){
        var data = intent.getParcelableExtra<ValorantAgent>("data")!!
//        var photoAgent = findViewById<ImageView>(data.photo_Agent)
        binding.picAgent.setImageResource(data.photo_Agent)
        binding.tvNameAgent.text = data.name
        binding.jenisAgent.text = data.jenisAgent
        binding.txtDesc.text = data.desc


        binding.textSkillOne.text = data.skillOne
        binding.textSkillTwo.text = data.skillTwo
        binding.textSkillThree.text = data.skillThree
        binding.textUlt.text = data.ult

        binding.picSkillOne.setImageResource(data.photoSkillOne)
        binding.picSkillTwo.setImageResource(data.photoSkillTwo)
        binding.picSkillThree.setImageResource(data.photoSkillThree)
        binding.picUlt.setImageResource(data.photoUlt)




    }

    fun favClick(){
        var fav = false
        binding.loveButton.setOnClickListener(){
            if (!fav) {
                Toast.makeText(this, "Add To Favorite", Toast.LENGTH_SHORT).show()
                binding.loveButton.setImageResource(R.drawable.ic_baseline_favorite_24)
                fav = true
            } else {
                Toast.makeText(this, "Remove From Favorite", Toast.LENGTH_SHORT).show()
                binding.loveButton.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                fav = false
            }
        }
    }

    fun shareClick(){
        binding.actionShare.setOnClickListener(){
            var url = intent.getStringExtra("url")
            val share = Intent()
            share.action = Intent.ACTION_SEND
            share.putExtra(Intent.EXTRA_TEXT, "Look at this agent!: $url")
            share.type = "text/plain"
            startActivity(Intent.createChooser(share, "Share To:"))
        }
    }
}