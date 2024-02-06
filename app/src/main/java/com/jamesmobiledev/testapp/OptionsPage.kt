package com.jamesmobiledev.testapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.jamesmobiledev.testapp.databinding.FragmentOptionsPageBinding

class OptionsPage : Fragment(R.layout.fragment_options_page) {
    private lateinit var binding: FragmentOptionsPageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOptionsPageBinding.inflate(inflater, container, false)

        initViews()
        return binding.root
    }

    private fun initViews() {
        binding.btnShopProfile.setOnClickListener {
            findNavController().navigate(R.id.action_optionsPage_to_shopProfileFragment)
        }
    }
}
