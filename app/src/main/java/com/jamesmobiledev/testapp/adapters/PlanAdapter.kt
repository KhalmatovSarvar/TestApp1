package com.jamesmobiledev.testapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.jamesmobiledev.testapp.R
import com.jamesmobiledev.testapp.databinding.ItemPlanBinding
import com.jamesmobiledev.testapp.models.Plan

class PlanAdapter(
    private val planList: List<Plan>,
) : RecyclerView.Adapter<PlanAdapter.PlanHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanHolder {
        val itemBinding =
            ItemPlanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlanHolder(itemBinding)
    }


    override fun onBindViewHolder(holder: PlanHolder, position: Int) {
        val plan = planList[position]
        holder.bind(plan)
    }

    override fun getItemCount(): Int = planList.size

    class PlanHolder(private val itemBinding: ItemPlanBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(plan: Plan) {
            itemBinding.apply {
            tvName.text = plan.type
            tvCountCashiers.text = plan.cashierCount
            tvCountShops.text = plan.shopsCount
            }

        }
    }
}