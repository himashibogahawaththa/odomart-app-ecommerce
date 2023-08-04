package com.example.odomartadsapp.views.sharedPref

import android.content.Context
import android.content.SharedPreferences

class PrefManager(context: Context) {
    val PRIVATE_MODE = 0

    private val PREF_NAME = "SharedPreferences"

    private val pref: SharedPreferences? = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
    private val editor: SharedPreferences.Editor? = pref?.edit()

}