package com.example.task3.data

import com.example.task3.model.Student
import java.util.HashMap

object DataSource {

    private val ITEMS: MutableSet<Student> = mutableSetOf()

    private val ITEM_MAP: MutableMap<String?, Student> = HashMap()

    private val ITEMS_DELETED: MutableList<Student> = mutableListOf()

    private var count = 25

    init {
        // Add some sample items.
        for (i in 1..count) {
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
        addItem(createItem(++count, name))
    }

    fun containsStudent(name: String?): Boolean = ITEM_MAP.containsKey(name)

    fun deleteStudent(student: Student): Boolean {
        if (ITEMS.contains(student)) {
            ITEMS_DELETED.add(student)
            if (ITEMS_DELETED.size > 5) {
                ITEMS_DELETED.removeFirst()
            }
            ITEM_MAP.remove(student.name)
            ITEMS.remove(student)
            return true
        }
        return false
    }

    fun restoreStudent(): String? {
        return if (ITEMS_DELETED.isEmpty()) null
        else {
            val student = ITEMS_DELETED.removeLast()
            ITEMS.add(student)
            ITEM_MAP[student.name] = student
            student.name
        }
    }
}