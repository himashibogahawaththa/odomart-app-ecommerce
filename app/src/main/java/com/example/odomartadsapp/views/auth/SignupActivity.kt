package com.example.odomartadsapp.views.auth

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.odomartadsapp.R
import com.example.odomartadsapp.views.CheckUserActivity
import com.example.odomartadsapp.views.home.MainActivity
import com.example.odomartadsapp.views.sharedPref.PrefManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignupActivity : AppCompatActivity() {
    private lateinit var name: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var confirmPassword: EditText
    private lateinit var signupBtn: Button
    private lateinit var loginBtn: Button
    private lateinit var auth: FirebaseAuth
    private lateinit var prefManager: PrefManager
    private lateinit var progressDialog: ProgressDialog

    private var emailPattern: Regex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        init()

        signupBtn.setOnClickListener {
            val sName = name.text.toString()
            val sEmail = email.text.toString()
            val sPassword = password.text.toString()
            val sConfirmPassword = confirmPassword.text.toString()

            validation(sName, sEmail, sPassword, sConfirmPassword)
        }

        loginBtn.setOnClickListener {
            val intent = Intent(this@SignupActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun init(){
        name = findViewById(R.id.sin_name_input)
        email = findViewById(R.id.sin_email_input)
        password = findViewById(R.id.sin_password_input)
        confirmPassword = findViewById(R.id.sin_confirm_password_input)
        signupBtn = findViewById(R.id.sin_signup_btn)
        loginBtn = findViewById(R.id.sin_login_btn)
        auth = Firebase.auth
        prefManager = PrefManager(this)
        progressDialog = ProgressDialog(this@SignupActivity)
    }

    private fun validation(Name: String, Email: String, Password: String, ConfirmPassword: String){
        if (Name.isEmpty()){
            name.error = "Please enter your Name"
        }
        else if (Email.isEmpty()){
            email.error = "Please enter your Email"
        }
        else if (Password.isEmpty()){
            password.error = "Please enter Password"
        }
        else if (ConfirmPassword.isEmpty()){
            confirmPassword.error = "Please Confirm your password"
        }
        else if (!Email.matches(emailPattern)){
            email.error = "Enter Correct Email"
        }
        else if (Password.isEmpty() || Password.length<6){
            password.error = "Input proper password"
        }
        else if(Password != ConfirmPassword){
            confirmPassword.error = "Password not matched"
        }
        else{
            progressDialog.setMessage("Wait until Register")
            progressDialog.setTitle("Registration")
            progressDialog.setCanceledOnTouchOutside(false)
            progressDialog.show()

            auth.createUserWithEmailAndPassword(Email, Password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        updateUI(user)

                        progressDialog.dismiss()
                        sendUserToNextActivity()
                        Toast.makeText(baseContext, "Authentication Successful.",Toast.LENGTH_SHORT).show()
                    } else {
                        updateUI(null)
                        progressDialog.dismiss()
                        Toast.makeText(baseContext, "Authentication failed.",Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

    private fun sendUserToNextActivity() {
        val intent = Intent(this@SignupActivity, MainActivity::class.java)
        startActivity(intent)
    }

    private fun updateUI(user: FirebaseUser?) {

    }

}