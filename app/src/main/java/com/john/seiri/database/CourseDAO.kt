package com.john.seiri.database

import androidx.room.*
import com.john.seiri.model.Course
import com.john.seiri.model.CourseAndProfessor

@Dao
interface CourseDAO {

    @Insert
    fun insertCourseAnd(course: Course)

    @Update
    fun updateCourse(course: Course)

    @Delete
    fun deleteCourse(course: Course)

    @Transaction
    @Query("SELECT * FROM Course")
    fun getCoursesAndProfessors(): ArrayList<CourseAndProfessor>
}