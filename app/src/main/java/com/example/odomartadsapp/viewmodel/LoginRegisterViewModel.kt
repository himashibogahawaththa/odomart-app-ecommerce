package com.example.odomartadsapp.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.odomartadsapp.model.AppRepository
import com.google.firebase.auth.FirebaseUser

class LoginRegisterViewModel : ViewModel() {
    private var appRepository: AppRepository = AppRepository()
    private var userMutableLiveData: MutableLiveData<FirebaseUser> = AppRepository().userMutableLiveData()

    fun register(email: String, password: String){

        appRepository.register(email, password)

    }

    fun userMutableLiveData(): MutableLiveData<FirebaseUser> {
        return userMutableLiveData
    }
}