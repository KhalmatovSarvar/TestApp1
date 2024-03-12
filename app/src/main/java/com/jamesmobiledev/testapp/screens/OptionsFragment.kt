package com.jamesmobiledev.testapp.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jamesmobiledev.testapp.R
import com.jamesmobiledev.testapp.databinding.FragmentOptionsPageBinding

class OptionsFragment : Fragment(R.layout.fragment_options_page) {
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
        binding.btnSubscription.setOnClickListener {
            findNavController().navigate(R.id.action_optionsPage_to_subscriptionFragment)
        }
        binding.btnManageLoaners.setOnClickListener {
            findNavController().navigate(R.id.action_optionsPage_to_manageLoanersFragment)
        }
        binding.btnItemList.setOnClickListener {
            findNavController().navigate(R.id.action_optionsPage_to_listOfItemsFragment)
        }
    }
}