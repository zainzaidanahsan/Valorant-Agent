package com.zain.submission_basic_android.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zain.submission_basic_android.R

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        val actionbar = supportActionBar
        actionbar!!.title = "About"
    }

}