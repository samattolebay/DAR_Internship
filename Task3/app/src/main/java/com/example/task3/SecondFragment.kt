package com.example.task3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.task3.model.Student

class SecondFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        val student = arguments?.getParcelable<Student>(Student.STUDENT)

        if (student != null) {
            view.findViewById<TextView>(R.id.tvStudentInfo).text = context?.getString(
                R.string.student_info,
                context?.getString(R.string.student_id, student.id.toString()),
                context?.getString(R.string.student_name, student.name),
                context?.getString(R.string.student_surname, student.surname),
                context?.getString(R.string.student_grade, student.grade.toString()),
                context?.getString(R.string.student_image, student.image))
        }

        return view
    }
}