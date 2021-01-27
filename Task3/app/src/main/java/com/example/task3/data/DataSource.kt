package com.example.task3.data

import com.example.task3.model.Student
import java.util.HashMap

object DataSource {

    private val ITEMS: MutableSet<Student> = mutableSetOf()

    private val ITEM_MAP: MutableMap<String?, Student> = HashMap()

    private const val COUNT = 25

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(createItem(i))
        }
    }

    private fun addItem(item: Student) {
        ITEMS.add(item)
        ITEM_MAP[item.name] = item
    }

    private fun createItem(
        position: Int,
        name: String = "Student $position",
        surname: String? = null,
        grade: Double = (position * 10).toDouble(),
        image: String? = null
    ): Student = Student(position, name, grade = grade)

    fun getStudents(): List<Student> = ITEMS.toList()

    fun addStudent(name: String) {
        addItem(createItem(ITEMS.size + 1, name))
    }

    fun containsStudent(name: String?): Boolean = ITEM_MAP.containsKey(name)
}