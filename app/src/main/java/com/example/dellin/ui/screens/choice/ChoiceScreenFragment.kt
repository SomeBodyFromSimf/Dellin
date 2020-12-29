package com.example.dellin.ui.screens.choice

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.animation.doOnEnd
import androidx.fragment.app.viewModels
import androidx.transition.ChangeBounds
import androidx.transition.TransitionInflater
import com.example.dellin.R
import com.example.dellin.base.BaseFragment
import com.example.dellin.databinding.ChoiceScreenBinding
import com.example.dellin.utils.onAnimEnd
import com.example.dellin.utils.singleClicker
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChoiceScreenFragment: BaseFragment<ChoiceScreenVM, ChoiceScreenBinding>(R.layout.choice_screen) {

    override val viewModel: ChoiceScreenVM by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(R.transition.change_bounds)
        sharedElementReturnTransition =  TransitionInflater.from(context).inflateTransition(R.transition.change_bounds)
        sharedElementEnterTransition = ChangeBounds().apply {
            duration = 750
            onAnimEnd { init() }
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    private fun init() {
        ObjectAnimator.ofFloat(1f, 0.8f).apply {
            duration = 750
            interpolator = AccelerateDecelerateInterpolator()
            addUpdateListener { valueAnimator -> with(binding.guideline) {
                val lp = layoutParams as ConstraintLayout.LayoutParams
                lp.guidePercent = valueAnimator.animatedValue as Float
                layoutParams = lp
            }}
            doOnEnd {
                initListeners()
                ObjectAnimator.ofFloat(binding.delLogo, "alpha", 1f).apply {
                    duration = 1000
                    start()
                }
            }
            start()
        }
    }

    private fun initListeners() { binding.apply {
        btnSignIn singleClicker {
        }
        btnSignUp singleClicker {
        }
    }}

}