package com.example.dellin.ui.screens.signup

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.dellin.R
import com.example.dellin.base.BaseFragment
import com.example.dellin.databinding.SignUpScreenBinding

class SignUpFragment : BaseFragment<SignUpVM, SignUpScreenBinding>(R.layout.sign_up_screen){
    override val viewModel: SignUpVM by viewModels()
}