package com.example.dellin.ui.screens.splash

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import com.example.dellin.base.BaseVM
import com.example.dellin.base.Event
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenVM @ViewModelInject constructor(): BaseVM(){

    init {
        startTimer()
    }

    private fun startTimer() = viewModelScope.launch {
        delay(3000)
        tasksEventChannel.send(SplashScreenEvent.TimerEndEvent)
    }
}

sealed class SplashScreenEvent: Event() {
    object TimerEndEvent : SplashScreenEvent()
}