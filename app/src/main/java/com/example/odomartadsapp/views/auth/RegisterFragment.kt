package com.example.odomartadsapp.views.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.odomartadsapp.R
import com.example.odomartadsapp.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private var emailPattern: Regex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observer()
        binding.sinSignupBtn.setOnClickListener {
            if (validation()){
                
            }
        }
    }

    private fun validation(): Boolean {
        var isValid = true

        if (binding.sinNameInput.text.isNullOrEmpty()){
            isValid = false
            binding.sinNameInput.error = "Please enter your Name"
        }
        else if (binding.sinEmailInput.text.isNullOrEmpty()){
            isValid = false
            binding.sinEmailInput.error = "Please enter your Email"
        }
        else if (binding.sinPasswordInput.text.isNullOrEmpty()){
            isValid = false
            binding.sinPasswordInput.error = "Please enter Password"
        }
        else if (binding.sinConfirmPasswordInput.text.isNullOrEmpty()){
            isValid = false
            binding.sinConfirmPasswordInput.error = "Please Confirm your password"
        }
        else if (!binding.sinEmailInput.text.matches(emailPattern)){
            isValid = false
            binding.sinEmailInput.error = "Enter Correct Email"
        }
        else if (binding.sinPasswordInput.text.isNullOrEmpty() ||
            binding.sinPasswordInput.text.length<6){
            isValid = false
            binding.sinPasswordInput.error = "Input proper password"
        }
        else {
            if(binding.sinPasswordInput.text != binding.sinConfirmPasswordInput.text){
                isValid = false
                binding.sinConfirmPasswordInput.error = "Password not matched"
            }
        }
        return isValid
    }

    private fun observer() {

    }
}