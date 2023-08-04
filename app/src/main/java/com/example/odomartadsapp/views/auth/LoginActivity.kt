package com.example.odomartadsapp.views.auth

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.odomartadsapp.R
import com.example.odomartadsapp.views.home.MainActivity
import com.example.odomartadsapp.views.sharedPref.PrefManager
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var email: TextInputEditText
    private lateinit var password: TextInputEditText
    private lateinit var loginBtn: Button
    private lateinit var signupBtn: Button
    private lateinit var forgotBtn: TextView
    private var emailPattern: Regex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()
    private lateinit var auth: FirebaseAuth
    private lateinit var prefManager: PrefManager
    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()

        loginBtn.setOnClickListener {
            checkLoginAuth()
        }

        signupBtn.setOnClickListener {
            val intent = Intent(this@LoginActivity, SignupActivity::class.java)
            startActivity(intent)
        }
    }

    private fun checkLoginAuth() {
        val sEmail = email.text.toString()
        val sPassword = password.text.toString()

        if (sEmail.isEmpty()){
            email.error = "Email is required"
        }
        else if (!sEmail.matches(emailPattern)){
            email.error = "Enter Correct Email"
        }
        else if (sPassword.isEmpty()){
            password.error = "Password is required"
        }
        else if (sPassword.length < 6){
            password.error = "Input proper password"
        }
        else{
            progressDialog.setMessage("Wait until Login")
            progressDialog.setTitle("Login")
            progressDialog.setCanceledOnTouchOutside(false)
            progressDialog.show()

            auth.signInWithEmailAndPassword(sEmail, sPassword)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        updateUI(user)
                        progressDialog.dismiss()
                        sendUserToNextActivity()
                        Toast.makeText(baseContext, "Authentication Successful.", Toast.LENGTH_SHORT).show()
                    } else {
                        updateUI(null)
                        progressDialog.dismiss()
                        Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

    private fun sendUserToNextActivity() {
        val intent = Intent(this@LoginActivity, MainActivity::class.java)
        startActivity(intent)
    }

    private fun updateUI(user: FirebaseUser?) {

    }

    fun init(){
        email = findViewById(R.id.log_email_input)
        password = findViewById(R.id.log_password_input)
        loginBtn = findViewById(R.id.log_login_btn)
        signupBtn = findViewById(R.id.log_signup_btn)
        forgotBtn = findViewById(R.id.log_forgot_txt)
        prefManager = PrefManager(this)
        auth = Firebase.auth
        progressDialog = ProgressDialog(this@LoginActivity)
    }
}