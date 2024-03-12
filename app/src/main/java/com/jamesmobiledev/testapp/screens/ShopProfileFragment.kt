package com.jamesmobiledev.testapp.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.jamesmobiledev.testapp.R
import com.jamesmobiledev.testapp.adapters.CashierAdapter
import com.jamesmobiledev.testapp.data.DummyCashierData
import com.jamesmobiledev.testapp.databinding.FragmentShopProfileBinding
import com.jamesmobiledev.testapp.models.Cashier
import com.jamesmobiledev.testapp.widgets.AddEditCashierDialog

class ShopProfileFragment : Fragment(R.layout.fragment_shop_profile){
    private lateinit var binding: FragmentShopProfileBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var cashierList: List<Cashier>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShopProfileBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set the toolbar as the action bar
        val toolbar = binding.toolbar
        toolbar.title = "Shop Profile" // Set the title of the toolbar
        toolbar.setNavigationOnClickListener {
            // Handle back button click
            findNavController().popBackStack()
        }

        val dummyData = DummyCashierData()
        cashierList = dummyData.cashierList

        recyclerView = binding.rvCashier
        recyclerView.adapter = CashierAdapter(cashierList) { cashier, position ->
            val args = Bundle().apply {
                putString("name", cashier.name)
                putString("password", cashier.password)
                putInt("position", position)
            }
            val dialog = AddEditCashierDialog(){
                cashier.isChecked = false
                recyclerView.adapter?.notifyItemChanged(position)
            }
            dialog.arguments = args
            dialog.show(parentFragmentManager, "Alert")


        }


    }


}