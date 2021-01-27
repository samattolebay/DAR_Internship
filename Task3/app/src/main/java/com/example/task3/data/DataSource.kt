package com.example.task3.data

import android.os.Parcel
import android.os.Parcelable
import com.example.task3.model.Student
import java.util.HashMap

object DataSource {

    private val ITEMS: MutableSet<Student> = mutableSetOf()

    private val ITEM_MAP: MutableMap<Int, Student> = HashMap()

    private const val COUNT = 25

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(createItem(i))
        }
    }

    private fun addItem(item: Student) {
        ITEMS.add(item)
        ITEM_MAP[item.id] = item
    }

    private fun createItem(position: Int): Student {
        return Student(position, "Student $position", grade = (position * 10).toDouble())
    }

    fun getStudents(): List<Student> = ITEMS.toList()
}