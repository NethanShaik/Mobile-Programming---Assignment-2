package com.example.assignment_2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CustomAdapter(private val context: Context, private val taskList: MutableList<Pair<String, String>>) : BaseAdapter() {

    override fun getCount(): Int {
        return taskList.size
    }

    override fun getItem(position: Int): Any {
        return taskList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        val itemText: TextView = view.findViewById(R.id.item_text)
        val subitemText: TextView = view.findViewById(R.id.subitem_text)

        val task = taskList[position]
        itemText.text = task.first
        subitemText.text = task.second

        return view
    }
}
