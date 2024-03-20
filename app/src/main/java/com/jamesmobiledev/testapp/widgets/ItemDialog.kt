package com.jamesmobiledev.testapp.widgets

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.PopupMenu
import android.widget.PopupMenu.OnDismissListener
import android.widget.Spinner
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.RecyclerView
import com.jamesmobiledev.testapp.R
import com.jamesmobiledev.testapp.databinding.DialogAddEditCashierBinding
import com.jamesmobiledev.testapp.databinding.DialogItemBinding
import com.jamesmobiledev.testapp.models.Cashier

class ItemDialog(
    private val onDismiss: () -> Unit,
) : DialogFragment(R.layout.dialog_item){

    lateinit var deliverSpinner:Spinner
    lateinit var unitTypeSpinner:Spinner
    lateinit var categorySpinner:Spinner
    private var _binding: DialogItemBinding? = null
    private val binding get() = _binding!!





    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogItemBinding.inflate(inflater, container, false)
        dialog?.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       binding.btn1.setOnClickListener {
           binding.btn1.setTextColor(Color.WHITE)
           binding.btn2.setTextColor(Color.BLACK)
       }

        binding.btn2.setOnClickListener {
            binding.btn2.setTextColor(Color.WHITE)
            binding.btn1.setTextColor(Color.BLACK)
        }

        binding.btnCancel.setOnClickListener {
            dismiss()
        }

        binding.btnSave.setOnClickListener {
            if (
                binding.etName.text.isNotEmpty() &&
                binding.etBarcode.text.isNotEmpty() &&
                binding.etMargin.text.isNotEmpty() &&
                binding.etPurchase.text.isNotEmpty() &&
                binding.etLeftStock.text.isNotEmpty() &&
                binding.etSell.text.isNotEmpty() &&
                binding.etMarkup.text.isNotEmpty()
            ) {
                Toast.makeText(requireContext(), "Saved successfully", Toast.LENGTH_SHORT).show()
                dismiss()
            } else {
                Toast.makeText(requireContext(), "Fields  should not be empty!", Toast.LENGTH_SHORT).show()

            }

        }

        deliverSpinner = binding.codeSpinnerDeliver
        categorySpinner = binding.codeSpinnerCategory
        unitTypeSpinner = binding.codeSpinnerUnitType
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.delivers,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears.
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner.
            deliverSpinner.adapter = adapter
        }

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.pcs,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears.
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner.
            unitTypeSpinner.adapter = adapter
        }

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.categories,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears.
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner.
            categorySpinner.adapter = adapter
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onStart() {
        super.onStart()

        // Calculate the position of the dialog
        val dialogWindow = dialog?.window
        dialogWindow?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        onDismiss.invoke()
    }
}