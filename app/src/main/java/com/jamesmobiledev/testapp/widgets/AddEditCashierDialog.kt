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
import android.widget.PopupMenu
import android.widget.PopupMenu.OnDismissListener
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.RecyclerView
import com.jamesmobiledev.testapp.R
import com.jamesmobiledev.testapp.databinding.DialogAddEditCashierBinding
import com.jamesmobiledev.testapp.models.Cashier

class AddEditCashierDialog  (
    private val onDismiss: () -> Unit,
) : DialogFragment(R.layout.dialog_add_edit_cashier){

    private var _binding: DialogAddEditCashierBinding? = null
    private val binding get() = _binding!!
    var nameArgs: String? = null
    var positionArgs: Int? = null
    var passwordArgs: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = arguments
        nameArgs = args?.getString("name")
        passwordArgs = args?.getString("password")
        positionArgs = args?.getInt("position")
    }




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogAddEditCashierBinding.inflate(inflater, container, false)
        dialog?.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Access views using view binding
        if (nameArgs != null) {
        binding.etName.setText(nameArgs)
        binding.etPassword.setText(passwordArgs) // Your EditText
        } else {
            binding.etName.setText("")
            binding.etPassword.setText("")
        }

        // Example of setting a click listener on a button
        binding.btnDelete.setOnClickListener {
            Toast.makeText(requireContext(), "Deleted successfully", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        binding.btnSave.setOnClickListener {
            if (binding.etName.text.isEmpty() || binding.etPassword.text.isEmpty()) {
                Toast.makeText(requireContext(), "Fill the required fields", Toast.LENGTH_SHORT)
                    .show()
            } else {
            Toast.makeText(requireContext(), "Saved successfully", Toast.LENGTH_SHORT).show()
            dismiss()
            }
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
        if (positionArgs!=null) {




            // Get the position of the item in RecyclerView
            val recyclerView = activity?.findViewById<RecyclerView>(R.id.rv_cashier)
            val itemView = recyclerView?.layoutManager?.findViewByPosition(positionArgs!!)
            val location = IntArray(2)
            itemView?.getLocationOnScreen(location)

            // Get the width of the screen
            val displayMetrics = resources.displayMetrics
            val screenWidth = displayMetrics.widthPixels

            // Calculate the desired width of the dialog
            val dialogWidth = screenWidth - 4


            val layoutParams = dialogWindow?.attributes



            // Adjust the dialog position below the item
            dialogWindow?.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL)
            layoutParams?.y = location[1] + itemView?.height!!
            dialogWindow?.attributes = layoutParams

            layoutParams?.width = dialogWidth
            layoutParams?.horizontalMargin = 0.1f // Example value for horizontal margin, adjust as needed


        }

    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        onDismiss.invoke()
    }
}