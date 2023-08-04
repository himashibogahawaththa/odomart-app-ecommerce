package com.example.odomartadsapp.model

data class User(
    var id: Int,
    var name: String,
    var username: String,
    var email: String,
    var password: String,
    var confirmPassword: String,
    var userType: String
)
