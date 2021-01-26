package com.example.task3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class SecondFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        val id = 1
        view.findViewById<TextView>(R.id.tvStudentID).text = "ID: ${id.toString()}"

        val name = "Samat"
        view.findViewById<TextView>(R.id.tvStudentName).text = "Name: $name"

        val surname = "Tolebay"
        view.findViewById<TextView>(R.id.tvStudentSurname).text = "Surname: $surname"

        val grade = 75.5
        view.findViewById<TextView>(R.id.tvStudentGrade).text = "Grade: $grade"

        return view
    }
}