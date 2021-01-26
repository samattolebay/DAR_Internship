package com.example.task3.dummy

import java.util.ArrayList
import java.util.HashMap

object DataSource {

    private val ITEMS: MutableList<Student> = ArrayList()

    private val ITEM_MAP: MutableMap<Int, Student> = HashMap()

    private const val COUNT = 25

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(createDummyItem(i))
        }
    }

    private fun addItem(item: Student) {
        ITEMS.add(item)
        ITEM_MAP[item.id] = item
    }

    private fun createDummyItem(position: Int): Student {
        return Student(position, "Student $position", grade = (position * 10).toDouble())
    }

    fun getStudents(): List<Student> = ITEMS

    data class Student(
        val id: Int,
        val name: String = "",
        val surname: String = "",
        val grade: Double = 0.0
    ) {
        override fun toString(): String = "$id - $name"
    }
}