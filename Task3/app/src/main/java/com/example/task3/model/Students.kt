package com.example.task3.model

import android.os.Parcel
import android.os.Parcelable

data class Student(
    val id: Int,
    val name: String? = null,
    val surname: String? = null,
    val grade: Double? = null,
    val image: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString()
    )

    override fun toString(): String = "$id - $name"
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(surname)
        parcel.writeValue(grade)
        parcel.writeString(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Student> {
        const val STUDENT: String = "STUDENT"

        override fun createFromParcel(parcel: Parcel): Student {
            return Student(parcel)
        }

        override fun newArray(size: Int): Array<Student?> {
            return arrayOfNulls(size)
        }
    }
}