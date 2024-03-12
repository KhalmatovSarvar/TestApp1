package com.jamesmobiledev.testapp.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.jamesmobiledev.testapp.R
import com.jamesmobiledev.testapp.adapters.PlanAdapter
import com.jamesmobiledev.testapp.data.DummyCashierData
import com.jamesmobiledev.testapp.data.DummyPlanData
import com.jamesmobiledev.testapp.databinding.FragmentSubscriptionBinding
import com.jamesmobiledev.testapp.models.Cashier
import com.jamesmobiledev.testapp.models.Plan

class SubscriptionFragment : Fragment(R.layout.fragment_subscription) {
    private lateinit var binding: FragmentSubscriptionBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var planList: List<Plan>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSubscriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Set the toolbar as the action bar
        val toolbar = binding.toolbar
        toolbar.setNavigationOnClickListener {
            // Handle back button click
            findNavController().popBackStack()
        }

        val dummyData = DummyPlanData()
        planList = dummyData.planList

        recyclerView = binding.rvSubscription
        recyclerView.adapter = PlanAdapter(planList)
    }


}