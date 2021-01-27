package com.example.task3

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.task3.data.DataSource
import com.google.android.material.textfield.TextInputLayout

/**
 * A fragment representing a list of Students.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val navController =
            activity?.let { it1 -> Navigation.findNavController(it1, R.id.fcvFragment) }

        val adapter = navController?.let { MyItemStudentAdapter(it) }
        adapter?.submitList(DataSource.getStudents())

        val rvListStudents = view.findViewById<RecyclerView>(R.id.rvListOfStudents)
        rvListStudents.adapter = adapter

        val addStudent = view.findViewById<Button>(R.id.btnAddStudent)
        val input = view.findViewById<TextInputLayout>(R.id.tilStudentName).editText

        addStudent.setOnClickListener {
            val name = input?.text.toString()
            if (DataSource.containsStudent(name)) {
                context?.let { it1 -> showToast(it1, "Student $name is already in the list!") }
            } else {
                DataSource.addStudent(name)
                adapter?.submitList(DataSource.getStudents())
                context?.let { it1 -> showToast(it1, "Student $name added to the list!") }
            }
        }

        return view
    }

    private fun showToast(context: Context, text: String) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show()
    }
}