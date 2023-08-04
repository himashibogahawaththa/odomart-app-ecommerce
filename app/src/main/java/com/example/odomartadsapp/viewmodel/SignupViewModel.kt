package com.example.odomartadsapp.viewmodel

import android.widget.Toast
import androidx.lifecycle.ViewModel

class SignupViewModel: ViewModel() {
    private var emailPattern: Regex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()

    fun userDetail(name: String, email: String, password: String, confirmPassword: String){
        if (name.isEmpty()){

        }
        else if (email.isEmpty()){

        }
        else if (password.isEmpty()){

        }
        else if (confirmPassword.isEmpty()){

        }
        else if (!email.matches(emailPattern)){

        }
        else if (password.isEmpty() || password.length<6){

        }
        else if(password != confirmPassword){

        }
        else{

        }
    }
}