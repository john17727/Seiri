package com.john.seiri.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.card.MaterialCardView
import com.john.seiri.R
import com.john.seiri.adapter.CourseAdapter
import com.john.seiri.model.CourseAndProfessor
import com.john.seiri.viewmodel.CoursesViewModel
import kotlinx.android.synthetic.main.courses_fragment.*


class Courses : Fragment(), CourseAdapter.OnCourseClickListener, CourseDetailDialogFragment.OnBottomSheetDismissed {

    private lateinit var courseAdapter: CourseAdapter
    private lateinit var courseCardView: MaterialCardView

    companion object {
        fun newInstance() = Courses()
    }

    private lateinit var viewModel: CoursesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.courses_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        startEnteringAnimation()

        viewModel = ViewModelProvider(this).get(CoursesViewModel::class.java)
        viewModel.init()
        viewModel.getCourses().observe(viewLifecycleOwner, Observer { courses ->
            courseAdapter.notifyDataSetChanged()
        })

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(activity)
        courseAdapter = viewModel.getCourses().value?.let { CourseAdapter(context!!, it, this) }!!

        courses_recycler.apply {
            layoutManager = linearLayoutManager
            adapter = courseAdapter
        }
    }

    override fun onCourseClick(course: CourseAndProfessor, courseCard: MaterialCardView) {
        courseCardView = courseCard
        startBottomSheetOpeningAnimation()

        val bundle = Bundle().apply {
            putParcelable("course", course)
        }

        CourseDetailDialogFragment(this).apply {
            arguments = bundle
            setColor(course.course.color)
        }.show(parentFragmentManager, "course_details")
    }

    // Set color of bottom sheet to the color of the card that was clicked
    private fun CourseDetailDialogFragment.setColor(color: Int) {
        when (color) {
            -14776091 -> setStyle(
                BottomSheetDialogFragment.STYLE_NORMAL,
                R.style.ThemeOverlay_MyTheme_BottomSheetDialog_Blue
            )
            -765666 -> setStyle(
                BottomSheetDialogFragment.STYLE_NORMAL,
                R.style.ThemeOverlay_MyTheme_BottomSheetDialog_Orange
            )
            -1754827 -> setStyle(
                BottomSheetDialogFragment.STYLE_NORMAL,
                R.style.ThemeOverlay_MyTheme_BottomSheetDialog_Red
            )
            -12345273 -> setStyle(
                BottomSheetDialogFragment.STYLE_NORMAL,
                R.style.ThemeOverlay_MyTheme_BottomSheetDialog_Green
            )
        }
    }

    // Callback from bottom sheet to start closing animations
    override fun onBottomSheetClose() {
        Log.d("DialogState", "Dismissed")
        startBottomSheetClosingAnimation()
    }

    // Animations to run when bottom sheet is opening
    private fun startBottomSheetOpeningAnimation() {
        val cardClick = AnimationUtils.loadAnimation(context, R.anim.card_click)
        courseCardView.startAnimation(cardClick)
        val shrink = AnimationUtils.loadAnimation(context, R.anim.recycler_fade_back)
        courses_recycler.startAnimation(shrink)
    }

    // Animation to run when bottom sheet is closing
    private fun startBottomSheetClosingAnimation() {
        val grow = AnimationUtils.loadAnimation(context, R.anim.recycler_fade_in)
        courses_recycler.startAnimation(grow)
        val cardClick = AnimationUtils.loadAnimation(context, R.anim.card_after_click)
        courseCardView.startAnimation(cardClick)

    }

    private fun startEnteringAnimation() {
        val fabEnter = AnimationUtils.loadAnimation(context, R.anim.fab_enter)
        add_course_fab.startAnimation(fabEnter)
    }
}
