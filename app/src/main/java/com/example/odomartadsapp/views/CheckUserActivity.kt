package com.example.odomartadsapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.odomartadsapp.R
import com.example.odomartadsapp.databinding.ActivityCheckUserBinding

class CheckUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCheckUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.buyerView, BuyerCardFragment())
            .commit()

    }
}