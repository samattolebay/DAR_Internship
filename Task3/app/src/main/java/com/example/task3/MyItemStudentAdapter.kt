package com.example.task3

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.example.task3.dummy.DataSource.Student

/**
 * [RecyclerView.Adapter] that can display a [Student].
 */
class MyItemStudentAdapter(
    private val values: List<Student>
) : RecyclerView.Adapter<MyItemStudentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.studentInfo.text = item.toString()
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val studentInfo: Button = view.findViewById(R.id.btnStudentInfo)
    }
}