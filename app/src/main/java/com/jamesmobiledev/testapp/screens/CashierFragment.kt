package com.jamesmobiledev.testapp.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jamesmobiledev.testapp.R
import com.jamesmobiledev.testapp.databinding.FragmentCashierBinding

class CashierFragment : Fragment(R.layout.fragment_cashier) {
    private lateinit var binding: FragmentCashierBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCashierBinding.inflate(inflater, container, false)

        return binding.root
    }


}