package com.example.task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val ttt = intent.getParcelableArrayListExtra<Student>("data")  as ArrayList<Student>

        val rv = findViewById<RecyclerView>(R.id.rvListOfStudents)

        val adapter = StudentAdapter(this, ttt)
        rv.adapter = adapter
    }
}