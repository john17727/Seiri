package com.john.seiri.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.lifecycle.ViewModelProvider
import com.john.seiri.R
import com.john.seiri.viewmodel.AssignmentsViewModel
import kotlinx.android.synthetic.main.assignments_fragment.*


class Assignments : Fragment() {

    companion object {
        fun newInstance() = Assignments()
    }

    private lateinit var viewModel: AssignmentsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.assignments_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        startEnteringAnimation()

        viewModel = ViewModelProvider(this).get(AssignmentsViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun startEnteringAnimation() {
        val fabEnter = AnimationUtils.loadAnimation(context, R.anim.fab_enter)
        add_assignment_fab.startAnimation(fabEnter)
    }

}
