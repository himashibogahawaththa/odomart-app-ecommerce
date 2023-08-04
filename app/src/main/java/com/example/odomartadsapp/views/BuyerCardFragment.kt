package com.example.odomartadsapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.odomartadsapp.R
import com.example.odomartadsapp.databinding.FragmentBuyerCardBinding

class BuyerCardFragment : Fragment() {
    private lateinit var binding: FragmentBuyerCardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBuyerCardBinding.inflate(layoutInflater)
        return binding.root
    }
}