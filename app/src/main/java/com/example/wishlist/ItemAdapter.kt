package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val items: ArrayList<Item>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        //set up views
        val itemNameTextView: TextView
        val itemPriceTextView: TextView
        val websiteTextView: TextView

        init {
            itemNameTextView = itemView.findViewById(R.id.itemNameTV)
            itemPriceTextView = itemView.findViewById(R.id.itemPriceTV)
            websiteTextView = itemView.findViewById(R.id.websiteTV)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // setup layout
        val contactView = inflater.inflate(R.layout.item_layout, parent, false)
        // return new holder
        return ViewHolder(contactView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        // set items how we want them
        holder.itemNameTextView.text = item.itemName
        holder.itemPriceTextView.text = item.priceAmount
        holder.websiteTextView.text = item.websiteURL
    }
}