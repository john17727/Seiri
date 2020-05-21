package com.john.seiri.repository

import android.content.res.Resources
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.john.seiri.model.Course
import com.john.seiri.model.CourseAndProfessor
import com.john.seiri.model.Professor

object Repository {
    private val coursesWithProfessor = ArrayList<CourseAndProfessor>()

    // Pretend to get data from database
    fun getCourses(): MutableLiveData<ArrayList<CourseAndProfessor>> {
        setCourses()

        return MutableLiveData<ArrayList<CourseAndProfessor>>().apply {
            value = coursesWithProfessor
        }
    }

    private fun setCourses() {
        coursesWithProfessor.clear()
        coursesWithProfessor.add(
            CourseAndProfessor(
                Course(
                    "Mobile App Development",
                    "CCSB",
                    "G0.0104",
                    arrayListOf(1, 3, 5),
                    "6 pm",
                    "8 pm",
                    -14776091
                ),
                Professor(
                    "Dr. Cheon",
                    "cheon@utep.edu",
                    "CCSB",
                    "4.0206",
                    arrayListOf(1, 3, 5),
                    "3 pm",
                    "4 pm",
                    "Mobile App Development"
                )
            )
        )

        coursesWithProfessor.add(
            CourseAndProfessor(
                Course(
                    "Software Engineering 2",
                    "CCSB",
                    "1.0256",
                    arrayListOf(1, 3, 5),
                    "11 am",
                    "1 pm",
                    -765666
                ),
                Professor(
                    "Dr. Roach",
                    "roach@utep.edu",
                    "CCSB",
                    "4.0139",
                    arrayListOf(1, 3, 5),
                    "8 am",
                    "9 am",
                    "Software Engineering 2"
                )
            )
        )

        coursesWithProfessor.add(
            CourseAndProfessor(
                Course(
                    "Software Construction",
                    "CCSB",
                    "1.0256",
                    arrayListOf(1, 3, 5),
                    "11 am",
                    "1 pm",
                    -1754827
                ),
                Professor(
                    "Dr. Roach",
                    "roach@utep.edu",
                    "CCSB",
                    "4.0139",
                    arrayListOf(1, 3, 5),
                    "8 am",
                    "9 am",
                    "Software Construction"
                )
            )
        )

        coursesWithProfessor.add(
            CourseAndProfessor(
                Course(
                    "Secure Web Development",
                    "CCSB",
                    "1.0256",
                    arrayListOf(1, 3, 5),
                    "11 am",
                    "1 pm",
                    -12345273
                ),
                Professor(
                    "Dr. Roach",
                    "roach@utep.edu",
                    "CCSB",
                    "4.0139",
                    arrayListOf(1, 3, 5),
                    "8 am",
                    "9 am",
                    "Secure Web Development"
                )
            )
        )
    }
}