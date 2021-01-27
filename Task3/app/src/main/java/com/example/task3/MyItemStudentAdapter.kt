package com.example.task3

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.example.task3.data.DataSource

import com.example.task3.model.Student

/**
 * [RecyclerView.Adapter] that can display a [Student].
 */
class MyItemStudentAdapter(
    private val context: Context,
    private val navController: NavController
) : RecyclerView.Adapter<MyItemStudentAdapter.ViewHolder>() {

    private var values: List<Student> = listOf()
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

        holder.deleteStudent.setOnClickListener {
            if (DataSource.deleteStudent(item)) {
                Toast.makeText(context, "Student ${item.name} is deleted from the list", Toast.LENGTH_LONG).show()
                submitList(DataSource.getStudents().toList())
            }
        }
    }

    override fun getItemCount(): Int = values.size

    fun submitList(listOfStudents: List<Student>?) {
        values = listOfStudents ?: listOf()
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val studentInfo: Button = view.findViewById(R.id.btnStudentInfo)
        val deleteStudent: Button = view.findViewById(R.id.btnDeleteStudent)
    }
}