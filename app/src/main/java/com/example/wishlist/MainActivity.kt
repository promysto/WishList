package com.example.wishlist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var items: ArrayList <Item>
    private lateinit var adapter : ItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        //set list
        items = ArrayList()

        //get recycler view id
        val itemRv = findViewById<RecyclerView>(R.id.ItemRv)

        //setup adapter and layout manager
        adapter = ItemAdapter(items)
        itemRv.adapter = adapter
        itemRv.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.button).setOnClickListener{
            addItem()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun addItem(){
        val itemVal = findViewById<EditText>(R.id.ItemNameET)
        val priceVal = findViewById<EditText>(R.id.ItemPriceET)
        val websiteVal = findViewById<EditText>(R.id.WebsiteET)

        val item = itemVal.text.toString()
        val price = priceVal.text.toString()
        val website = websiteVal.text.toString()
        items.add(Item(item, price, website))
        adapter.notifyDataSetChanged()
    }
}