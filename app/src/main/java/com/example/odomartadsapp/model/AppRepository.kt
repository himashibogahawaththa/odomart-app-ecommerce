package com.example.odomartadsapp.model

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AppRepository{
    private lateinit var auth: FirebaseAuth
    private var userMutableLiveData : MutableLiveData<FirebaseUser> = MutableLiveData<FirebaseUser>()

    fun register(email: String, password: String){
        auth = Firebase.auth

        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task: Task<AuthResult> ->
                    if (task.isSuccessful) {
                        userMutableLiveData.postValue(auth.currentUser)
                    } else {
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(
                            Application(), "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }


//        auth.createUserWithEmailAndPassword(email, password)
//            .addOnCompleteListener(application.mainExecutor, OnCompleteListener<AuthResult> {
//                fun onComplete(task: Task<AuthResult>){
//                    if (task.isSuccessful) {
//                        userMutableLiveData.postValue(auth.currentUser)
//                    } else {
//                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
//                        Toast.makeText(application, "Authentication failed.",
//                            Toast.LENGTH_SHORT).show()
//                    }
//                }
//            })

    fun userMutableLiveData(): MutableLiveData<FirebaseUser> {
        return userMutableLiveData
    }
}