package com.example.task2.data

import com.example.task2.model.Student
import java.util.ArrayList

class DataSource {
    fun loadStudents(): ArrayList<Student> {
        val listOfStudents = ArrayList<Student>()
        listOfStudents.add(Student("Samat", "Tolebay"))
        listOfStudents.add(Student("Ayan", "Zholdybayev"))
        listOfStudents.add(Student("Arystan", "Bakyt"))
        listOfStudents.add(Student("John", "Smith"))
        listOfStudents.add(Student("Steve", "Jobs"))
        listOfStudents.add(Student("Bill", "Gates"))
        return listOfStudents
    }
}