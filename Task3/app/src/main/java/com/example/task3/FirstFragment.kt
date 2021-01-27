package com.example.task3

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.example.task3.data.DataSource
import com.example.task3.model.Student

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

        val navController =
            activity?.let { it1 -> Navigation.findNavController(it1, R.id.fcvFragment) }

        val adapter = navController?.let { MyItemStudentAdapter(listOfStudents, it) }

        val rvListStudents = view.findViewById<RecyclerView>(R.id.rvListOfStudents)
        rvListStudents.adapter = adapter
        return view
    }
}