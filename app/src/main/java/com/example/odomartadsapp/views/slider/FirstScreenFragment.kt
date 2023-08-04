package com.example.odomartadsapp.views.slider

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.odomartadsapp.R
import com.example.odomartadsapp.viewmodel.ScreenSlidePageViewModel

class FirstScreenFragment : Fragment() {

    companion object {
        fun newInstance() = FirstScreenFragment()
    }

    private lateinit var viewModel: ScreenSlidePageViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first_screen, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ScreenSlidePageViewModel::class.java)
        // TODO: Use the ViewModel
    }

}