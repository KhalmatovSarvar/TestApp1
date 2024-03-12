package com.jamesmobiledev.testapp.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.jamesmobiledev.testapp.R
import com.jamesmobiledev.testapp.adapters.ItemListAdapter
import com.jamesmobiledev.testapp.data.DummyItemData
import com.jamesmobiledev.testapp.databinding.FragmentListOfItemsBinding
import com.jamesmobiledev.testapp.models.Item
import com.jamesmobiledev.testapp.widgets.ItemDialog
import com.jamesmobiledev.testapp.widgets.LoanerDialog

class ListOfItemsFragment : Fragment(R.layout.fragment_list_of_items) {
    private lateinit var binding: FragmentListOfItemsBinding
    private lateinit var itemList: List<Item>
    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListOfItemsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = binding.toolbar
        toolbar.setNavigationOnClickListener {
            // Handle back button click
            findNavController().popBackStack()
        }

        val dummyData = DummyItemData()
        itemList = dummyData.itemList

        recyclerView = binding.rvItems
        recyclerView.adapter = ItemListAdapter(itemList) { item ->
            val dialog = ItemDialog(){}
            dialog.show(parentFragmentManager, "Alert")

        }
    }

}