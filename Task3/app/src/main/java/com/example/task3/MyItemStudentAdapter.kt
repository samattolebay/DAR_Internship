package com.example.task3

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.NavController

import com.example.task3.model.Student

/**
 * [RecyclerView.Adapter] that can display a [Student].
 */
class MyItemStudentAdapter(
    private val values: List<Student>,
    private val navController: NavController
) : RecyclerView.Adapter<MyItemStudentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item, parent, false)
        Log.d("Hey", parent.parent.parent.javaClass.toString())
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.studentInfo.text = item.toString()

        holder.studentInfo.setOnClickListener {
            val bundle = bundleOf(Student.STUDENT to item)
            navController.navigate(R.id.navigateToSecondFragment, bundle)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val studentInfo: Button = view.findViewById(R.id.btnStudentInfo)
    }
}