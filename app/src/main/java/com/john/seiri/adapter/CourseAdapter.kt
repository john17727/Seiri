package com.john.seiri.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.john.seiri.R
import com.john.seiri.model.Course
import com.john.seiri.model.CourseAndProfessor

class CourseAdapter(private val context: Context, private val courses: ArrayList<CourseAndProfessor>, val onCourseClickListener: OnCourseClickListener): RecyclerView.Adapter<CourseAdapter.CourseHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_course, parent, false)
        return CourseHolder(view)
    }

    override fun getItemCount(): Int {
        return courses.size
    }

    override fun onBindViewHolder(holder: CourseHolder, position: Int) {
        holder.bind(courses[position])
    }

    inner class CourseHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val courseCard = view.findViewById<MaterialCardView>(R.id.card_view_course)
        private val courseName = view.findViewById<TextView>(R.id.card_course_name_text)
        private val courseDays = view.findViewById<TextView>(R.id.card_course_days_text)
        private val courseTime = view.findViewById<TextView>(R.id.card_course_time_text)

        fun bind(courseWithProfessor: CourseAndProfessor) {

            val course = courseWithProfessor.course
            courseCard.setCardBackgroundColor(course.color)
                courseName.text = course.courseName
            courseDays.text = course.days.toString()
            courseTime.text = course.timeStart + " - " + course.timeEnd

            courseCard.setOnClickListener {
                onCourseClickListener.onCourseClick(courseWithProfessor, courseCard)
            }
        }
    }

    interface OnCourseClickListener {
        fun onCourseClick(course: CourseAndProfessor, courseCard: MaterialCardView)
    }
}