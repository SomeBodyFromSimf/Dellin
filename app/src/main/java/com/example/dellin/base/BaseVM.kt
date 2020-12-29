package com.example.dellin.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

open class BaseVM: ViewModel() {

    protected val tasksEventChannel = Channel<Event>()
    val tasksEvent = tasksEventChannel.receiveAsFlow()
}

open class Event

object LogOffEvent: Event()