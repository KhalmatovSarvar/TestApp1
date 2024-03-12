package com.jamesmobiledev.testapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.jamesmobiledev.testapp.R
import com.jamesmobiledev.testapp.databinding.ItemCashierBinding
import com.jamesmobiledev.testapp.models.Cashier

class CashierAdapter(
    private val cashierList: List<Cashier>,
    private val onItemClick: (Cashier, Int) -> Unit,
) : RecyclerView.Adapter<CashierAdapter.CashierHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CashierHolder {
        val itemBinding =
            ItemCashierBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CashierHolder(itemBinding)
    }


    override fun onBindViewHolder(holder: CashierHolder, position: Int) {
        val cashier = cashierList[position]
        holder.bind(cashier)
        holder.itemView.setOnClickListener {
            cashier.isChecked = true
            onItemClick(cashier, position)
            if (cashier.isChecked) {
                holder.itemView.setBackgroundColor(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.item_click
                    )
                )
            } else {
                holder.itemView.setBackgroundColor(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.white
                    )
                )
            }
        }

        holder.itemView.setBackgroundColor(
            ContextCompat.getColor(
                holder.itemView.context,
                R.color.white
            )
        )

    }

    override fun getItemCount(): Int = cashierList.size

    class CashierHolder(private val itemBinding: ItemCashierBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(cashier: Cashier) {
            itemBinding.tvName.text = cashier.name
        }
    }
}