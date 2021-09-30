package com.malinikali.inventory.adapters

import android.content.ClipData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.malinikali.inventory.databinding.ItemListFragmentBinding
import com.malinikali.inventory.models.Item

class ItemListAdapter(private val onItemClicked: (Item)->Unit):ListAdapter<Item, ItemListAdapter.ItemViewHolder>(DiffCallback) {

    private val binding: ItemListFragmentBinding? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemListFragmentBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClicked(currentItem)
        }
        holder.bind(currentItem)
    }

    companion object{
        private val DiffCallback = object : DiffUtil.ItemCallback<Item>(){
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.itemName == newItem.itemName
            }

        }
    }

    class ItemViewHolder(private var binding: ItemListFragmentBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(item:Item){
            binding.apply{
                itemName.text = item.itemName
                itemPrice.text = item.itemPrice.toString()
                itemQuantity.text = item.quantityInStock.toString()
            }
        }
    }
}