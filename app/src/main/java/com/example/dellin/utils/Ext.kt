package com.example.dellin.utils

import android.os.SystemClock
import android.view.View
import androidx.transition.Transition

fun Transition.onAnimEnd(block: () -> Unit) {
    addListener(object: Transition.TransitionListener{
        override fun onTransitionStart(transition: Transition) {}
        override fun onTransitionEnd(transition: Transition) { block()}
        override fun onTransitionCancel(transition: Transition) {}
        override fun onTransitionPause(transition: Transition) {}
        override fun onTransitionResume(transition: Transition) {}
    })
}

infix fun View.singleClicker(action: () -> Unit) {
    setOnClickListener(object : View.OnClickListener {
        private var lastClickTime: Long = 0
        override fun onClick(v: View) {
            if (SystemClock.elapsedRealtime() - lastClickTime < 300L) return else action.invoke()
            lastClickTime = SystemClock.elapsedRealtime()
        }
    })
}

val <T> T.exhaustive: T
    get() = this