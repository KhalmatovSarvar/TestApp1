package com.jamesmobiledev.testapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.jamesmobiledev.testapp.R
import com.jamesmobiledev.testapp.databinding.ItemListBinding
import com.jamesmobiledev.testapp.models.Cashier
import com.jamesmobiledev.testapp.models.Item

class ItemListAdapter(
    private val itemList: List<Item>,
    private val onItemClick: (Item) -> Unit,
) : RecyclerView.Adapter<ItemListAdapter.ItemHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemBinding =
            ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemHolder(itemBinding)
    }


    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            onItemClick(item)
        }
    }

    override fun getItemCount(): Int = itemList.size

    class ItemHolder(private val itemBinding: ItemListBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: Item) {

        }
    }
}