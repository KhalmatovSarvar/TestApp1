package com.jamesmobiledev.testapp.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.jamesmobiledev.testapp.R
import com.jamesmobiledev.testapp.adapters.LoanAdapter
import com.jamesmobiledev.testapp.adapters.PlanAdapter
import com.jamesmobiledev.testapp.data.DummyLoanData
import com.jamesmobiledev.testapp.data.DummyPlanData
import com.jamesmobiledev.testapp.databinding.FragmentManageLoanersBinding
import com.jamesmobiledev.testapp.models.Loan
import com.jamesmobiledev.testapp.models.Plan
import com.jamesmobiledev.testapp.widgets.AddEditCashierDialog
import com.jamesmobiledev.testapp.widgets.LoanerDialog

class ManageLoanersFragment : Fragment(R.layout.fragment_manage_loaners) {
    private lateinit var binding: FragmentManageLoanersBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var loanList: List<Loan>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentManageLoanersBinding.inflate(inflater, container, false)
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

            val dummyData = DummyLoanData()
            loanList = dummyData.loanList

            recyclerView = binding.rvLoaners
            recyclerView.adapter = LoanAdapter(loanList)

             binding.btnAddCashier.setOnClickListener {
                 if ( binding.etCustomerName.text.isNotEmpty()&& binding.etPhoneNumber.text.isNotEmpty()){
                     val args = Bundle().apply {
                         putString("name", binding.etCustomerName.text.toString())
                     }
                     val dialog = LoanerDialog(){

                     }
                     dialog.arguments = args
                     dialog.show(parentFragmentManager, "Alert")
                 }else{
                     Toast.makeText(requireContext(), "Fill required fields", Toast.LENGTH_SHORT).show()
                 }

             }

        }
    }


