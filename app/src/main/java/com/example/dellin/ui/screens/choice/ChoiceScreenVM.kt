package com.example.dellin.ui.screens.choice

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.dellin.base.BaseVM
import com.example.dellin.base.Event

class ChoiceScreenVM @ViewModelInject constructor(): BaseVM() {

}

sealed class ChoiceEvent: Event() {
    object GoToSignIn : ChoiceEvent()
    object GoToMainScreen : ChoiceEvent()
}