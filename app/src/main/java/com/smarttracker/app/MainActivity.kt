package com.smarttracker.app

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val amountInput = findViewById<EditText>(R.id.amountInput)
        val addBtn = findViewById<Button>(R.id.addBtn)
        val listView = findViewById<ListView>(R.id.listView)

        val list = ArrayList<String>()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        listView.adapter = adapter

        addBtn.setOnClickListener {
            val amount = amountInput.text.toString()
            list.add("₹$amount")
            adapter.notifyDataSetChanged()
        }
    }
}
