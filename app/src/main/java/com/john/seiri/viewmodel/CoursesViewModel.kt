package com.john.seiri.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.john.seiri.model.CourseAndProfessor
import com.john.seiri.repository.Repository

class CoursesViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private lateinit var coursesWithProfessor: MutableLiveData<ArrayList<CourseAndProfessor>>

    fun init() {
        if (::coursesWithProfessor.isInitialized) {
            return
        }
        coursesWithProfessor = Repository.getCourses()
    }

    fun getCourses(): LiveData<ArrayList<CourseAndProfessor>> {
        return coursesWithProfessor
    }
}
