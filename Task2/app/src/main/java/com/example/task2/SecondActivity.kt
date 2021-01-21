package com.example.task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.task2.adapter.StudentAdapter
import com.example.task2.model.Student
import java.util.ArrayList

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val students = intent.getParcelableArrayListExtra<Student>("data") as ArrayList<Student>

        val rv = findViewById<RecyclerView>(R.id.rvListOfStudents)

        val adapter = StudentAdapter(this, students)
        rv.adapter = adapter
    }
}