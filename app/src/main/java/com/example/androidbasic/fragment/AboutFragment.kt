package com.example.androidbasic.fragment

import android.os.Bundle
import android.view.View
import com.example.androidbasic.databinding.FragmentAboutBinding

class AboutFragment : BaseFragment<FragmentAboutBinding>(FragmentAboutBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}