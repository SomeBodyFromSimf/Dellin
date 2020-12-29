package com.example.dellin.ui.screens.signin

import androidx.fragment.app.viewModels
import com.example.dellin.R
import com.example.dellin.base.BaseFragment
import com.example.dellin.databinding.SignInScreenBinding


class SignInFragment : BaseFragment<SignInVM, SignInScreenBinding>(R.layout.sign_in_screen){
    override val viewModel: SignInVM by viewModels()
}