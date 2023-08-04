package com.example.odomartadsapp.views.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.odomartadsapp.R

class AuthHomeActivity : AppCompatActivity() {
    private lateinit var googleBtn: Button
    private lateinit var facebookBtn: Button
    private lateinit var emailBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth_home)

        init()

        emailBtn.setOnClickListener {
            val intent = Intent(this@AuthHomeActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    fun init(){
        googleBtn = findViewById(R.id.googleBtn)
        facebookBtn = findViewById(R.id.facebookBtn)
        emailBtn = findViewById(R.id.emailBtn)
    }
}