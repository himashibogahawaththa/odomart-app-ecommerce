package com.example.odomartadsapp.views.slider

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.odomartadsapp.R
import com.example.odomartadsapp.databinding.ActivityMainBinding
import com.example.odomartadsapp.databinding.ActivitySliderBinding
import com.example.odomartadsapp.views.home.MainActivity
import com.example.odomartadsapp.views.sharedPref.PrefManager

class SliderActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var next : Button
    private lateinit var skip : Button
    private var fragment1 : FirstScreenFragment = FirstScreenFragment()
    private var fragment2 : FirstScreenFragment = FirstScreenFragment()
    private var fragment3 : FirstScreenFragment = FirstScreenFragment()
    private var fragment4 : FirstScreenFragment = FirstScreenFragment()
    private lateinit var prefManager: PrefManager
    private lateinit var binding: ActivitySliderBinding

    private lateinit var preferences: SharedPreferences

    val pref_show_intro = "Intro"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySliderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

        Log.d("gggg", "Slider activity ")

        val slides: ArrayList<Fragment> = arrayListOf(
            fragment1,
            fragment2,
            fragment3,
            fragment4,
        )

        val adapter = ViewPageAdapter(slides, this)
        viewPager.adapter = adapter

        prefManager = PrefManager(this)
        preferences = getSharedPreferences("OdoMartAdsApp", Context.MODE_PRIVATE)

        var value = viewPager.currentItem
        Log.d("gggg", "onCreate: $value")

        next.setOnClickListener {
            if(next.text == "Done"){
                val intent = Intent(this@SliderActivity, MainActivity::class.java)
                startActivity(intent)

                val editor = preferences.edit()
                editor.putBoolean(pref_show_intro, false)
                editor.apply()
            }
            onNextPressed()
            Log.d("gggg", "next clicked")
        }

        skip.setOnClickListener {
            val editor = preferences.edit()
            editor.putBoolean(pref_show_intro, false)
            editor.apply()

            val intent = Intent(this@SliderActivity, MainActivity::class.java)
            startActivity(intent)
            Log.d("gggg", "skip clicked")
        }
    }

    fun init(){
        viewPager = findViewById(R.id.pager)
        next = findViewById(R.id.next)
        skip = findViewById(R.id.skip)
    }

    override fun onBackPressed() {
        if (viewPager.currentItem == 0){
            super.onBackPressed()
        }
        else{
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }

    fun onNextPressed() {
        if (viewPager.currentItem < 2){
            next.text = "Next"
            viewPager.currentItem++
        }
        else{
            next.text = "Done"
            viewPager.currentItem++
        }
    }
}