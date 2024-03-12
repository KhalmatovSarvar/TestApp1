package com.jamesmobiledev.testapp.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.jamesmobiledev.testapp.databinding.ItemLoanerBinding
import com.jamesmobiledev.testapp.models.Loan

class LoanAdapter(
    private val planList: List<Loan>,
    private val onClick: (Loan)->Unit
) : RecyclerView.Adapter<LoanAdapter.LoanHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoanHolder {
        val itemBinding =
            ItemLoanerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LoanHolder(itemBinding)
    }


    override fun onBindViewHolder(holder: LoanHolder, position: Int) {
        val plan = planList[position]
        holder.bind(plan)
        holder.itemView.setOnClickListener{
            onClick(plan)
        }
    }

    override fun getItemCount(): Int = planList.size

    class LoanHolder(private val itemBinding: ItemLoanerBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(loan: Loan) {
            itemBinding.apply {
                tvName.text = loan.name
                tvMoney.text = "${loan.balance} ₸"
                tvPhone.text = loan.phone
                if(loan.balance.toInt()>0){
                tvMoney.setTextColor(Color.parseColor("#42CD00"))
                }else if(loan.balance.toInt()< -3000){
                    tvMoney.setTextColor(Color.parseColor("#FF5B14"))

                }else{
                    tvMoney.setTextColor(Color.parseColor("#FAFF00"))

                }
            }
        }

    }
}