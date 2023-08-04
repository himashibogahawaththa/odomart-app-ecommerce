package com.example.odomartadsapp.views.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.odomartadsapp.R
import com.example.odomartadsapp.views.home.MainActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
        finish()
    }
}