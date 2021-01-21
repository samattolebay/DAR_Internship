package com.example.task2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.task2.R
import com.example.task2.model.Student
import java.util.ArrayList

class StudentAdapter(private val context: Context,
                     private val dataSet: ArrayList<Student>) :
    RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textStudentInfo = view.findViewById<TextView>(R.id.tvStudentInfo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textStudentInfo.text = "${position + 1}. ${dataSet[position].name} ${dataSet[position].surname}"
    }

    override fun getItemCount() = dataSet.size


}