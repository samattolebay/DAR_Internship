package com.example.task3

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.task3.dummy.DataSource

/**
 * A fragment representing a list of Students.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val listOfStudents = DataSource.getStudents()
        val adapter = MyItemStudentAdapter(listOfStudents)

        val rvListStudents = view.findViewById<RecyclerView>(R.id.rvListOfStudents)
        rvListStudents.adapter = adapter

        return view
    }
}