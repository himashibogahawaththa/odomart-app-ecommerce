package com.example.odomartadsapp.views.home

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.odomartadsapp.R
import com.example.odomartadsapp.databinding.ActivityMainBinding
import com.example.odomartadsapp.views.auth.AuthHomeActivity
import com.example.odomartadsapp.views.auth.LoginActivity
import com.example.odomartadsapp.views.sharedPref.PrefManager
import com.example.odomartadsapp.views.slider.FirstScreenFragment
import com.example.odomartadsapp.views.slider.SliderActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var preferences: SharedPreferences
    private lateinit var prefManager: PrefManager
    private lateinit var logoutBtn: Button
    val pref_show_intro = "Intro"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

        logoutBtn.setOnClickListener {
            Firebase.auth.signOut()
            clickLogout(it)
        }

        if(preferences.getBoolean(pref_show_intro, true)){
            val intent = Intent(this@MainActivity, SliderActivity::class.java)
            startActivity(intent)
        }
        else{
            checkLogin()
        }
    }

    private fun init(){
        preferences = getSharedPreferences("OdoMartAdsApp", Context.MODE_PRIVATE)
        prefManager = PrefManager(this)
        logoutBtn = findViewById(R.id.logoutBtn)
    }

    private fun checkLogin() {
        val user = Firebase.auth.currentUser
        if (user == null) {
            startAuthHome()
        }
    }

    fun clickLogout(view: View){
        Firebase.auth.signOut()
        startAuthHome()
        finish()
    }

    fun startAuthHome(){
        val intent = Intent(this@MainActivity, AuthHomeActivity::class.java)
        startActivity(intent)
    }
}