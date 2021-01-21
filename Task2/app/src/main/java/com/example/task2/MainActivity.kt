package com.example.task2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonAddStudent = findViewById<Button>(R.id.btnAddStudent)

        val students = ArrayList<Student>()

        updateTextTotalNumber(students)

        buttonAddStudent.setOnClickListener {
            val nameInput = findViewById<TextInputLayout>(R.id.tilName)
            val name = nameInput.editText?.text.toString()

            val surnameInput = findViewById<TextInputLayout>(R.id.tilSurname)
            val surname = surnameInput.editText?.text.toString()

            var validInput = name.isNotBlank() && surname.isNotBlank()

            if (!validInput) {
                Toast.makeText(this, "Empty/Blank Input!!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            for (student in students) {
                if (student.name == name && student.surname == surname) {
                    validInput = false
                    break
                }
            }

            if (!validInput) {
                Toast.makeText(this, "Student is already added!!", Toast.LENGTH_LONG).show()
            } else {
                students.add(Student(name, surname))
                Toast.makeText(this, "Student added!!", Toast.LENGTH_LONG).show()
                updateTextTotalNumber(students)
            }
        }

        val buttonShowStudents = findViewById<Button>(R.id.btnShowStudents)

        buttonShowStudents.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putParcelableArrayListExtra("data", students)
            startActivity(intent)
        }
    }

    private fun updateTextTotalNumber(students: MutableList<Student>) {
        val textTotalNumber = findViewById<TextView>(R.id.tvTotalNumber)
        textTotalNumber.text = "Total number of students: ${students.size}"
    }
}