package com.john.seiri.fragment

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.john.seiri.R
import com.john.seiri.model.Course
import com.john.seiri.model.CourseAndProfessor
import com.john.seiri.model.Professor
import kotlinx.android.synthetic.main.fragment_course_detail_dialog.*


class CourseDetailDialogFragment(private val onBottomSheetDismissed: OnBottomSheetDismissed) : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_course_detail_dialog,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val courseDetails = arguments?.getParcelable<CourseAndProfessor>("course")
        Log.d("Dialog", arguments.toString())

        courseDetails?.course?.let { setCourseInfo(it) }
        courseDetails?.professor?.let { setProfessorInfo(it) }
    }

    private fun setProfessorInfo(professor: Professor) {
        details_professor.text = professor.professorName
        details_professor_email.text = professor.email
        details_professor_days.text = professor.days.toString()
        details_professor_time.text = professor.timeStart + " - " + professor.timeEnd
        details_professor_building.text = professor.building
        details_professor_room.text = professor.room
    }

    private fun setCourseInfo(course: Course) {
        details_course_name.text = course.courseName
        details_course_days.text = course.days.toString()
        details_course_time.text = course.timeStart + " - " + course.timeEnd
        details_course_building.text = course.building
        details_course_room.text = course.room
    }

    override fun onDismiss(dialog: DialogInterface) {
        Log.d("DialogState", "onDismiss")
        super.onDismiss(dialog)

        onBottomSheetDismissed.onBottomSheetClose()
    }

    interface OnBottomSheetDismissed {
        fun onBottomSheetClose()
    }
}
