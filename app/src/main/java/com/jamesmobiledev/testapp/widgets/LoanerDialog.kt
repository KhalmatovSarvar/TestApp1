package com.jamesmobiledev.testapp.widgets

import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.jamesmobiledev.testapp.R
import com.jamesmobiledev.testapp.databinding.DialogLoanerBinding

class LoanerDialog(
    private val onDismiss: () -> Unit,
) : DialogFragment(R.layout.dialog_loaner) {

    private var _binding: DialogLoanerBinding? = null
    private val binding get() = _binding!!
    var nameArgs: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = arguments
        nameArgs = args?.getString("name")

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogLoanerBinding.inflate(inflater, container, false)
        dialog?.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Access views using view binding
        binding.tvName.setText(nameArgs)


        binding.et1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                val text = p0.toString()
                var value = 0
                if (text.isNotEmpty()) {
                    try {
                        if (text.startsWith('-')) {
                            // If text starts with '-', parse the substring after it
                            value = text.substring(1).toInt()
                            if (value > 0 && value < 3000) {
                                binding.secondValue.setTextColor(Color.parseColor("#FAFF00"))
                            } else {
                                binding.secondValue.setTextColor(Color.parseColor("#FF5B14"))
                            }

                        } else {
                            binding.secondValue.setTextColor(Color.parseColor("#0EAB9D"))
                        }
                        binding.secondValue.text = "${text} ₸"
                    } catch (e: NumberFormatException) {
                        // Handle the case where the input cannot be converted to an integer
                        // For example, when the text contains non-numeric characters
                        // In this case, you may clear the TextView or show an error message
                        binding.secondValue.text = ""
                    }
                } else {
                    binding.secondValue.text = ""
                }
            }
        })

        binding.et2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                val text = p0.toString()
                var value = 0
                if (text.isNotEmpty()) {
                    try {
                        if (text.startsWith('-')) {
                            // If text starts with '-', parse the substring after it
                            value = text.substring(1).toInt()
                            if (value > 0 && value < 3000) {
                                binding.firstValue.setTextColor(Color.parseColor("#FAFF00"))
                            } else {
                                binding.firstValue.setTextColor(Color.parseColor("#FF5B14"))
                            }

                        } else {
                            binding.firstValue.setTextColor(Color.parseColor("#42CD00"))
                        }
                        binding.firstValue.text = "${text} ₸"
                    } catch (e: NumberFormatException) {
                        // Handle the case where the input cannot be converted to an integer
                        // For example, when the text contains non-numeric characters
                        // In this case, you may clear the TextView or show an error message
                        binding.firstValue.text = ""
                    }
                } else {
                    binding.firstValue.text = ""
                }
            }
        })

        // Example of setting a click listener on a button
        binding.btnCancel.setOnClickListener {
            dismiss()
        }

        binding.btnSave.setOnClickListener {
            Toast.makeText(requireContext(), "Saved successfully", Toast.LENGTH_SHORT).show()
            dismiss()
        }
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        onDismiss.invoke()
    }
}