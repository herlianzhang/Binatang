package com.latihangoding.binatang.About

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.latihangoding.binatang.R

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        title = "About"
    }
}
