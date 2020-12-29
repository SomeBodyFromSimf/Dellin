package com.example.dellin.ui.screens.splash

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.example.dellin.R
import com.example.dellin.base.BaseFragment
import com.example.dellin.base.Event
import com.example.dellin.databinding.SplashScreenBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
@AndroidEntryPoint
class SplashScreenFragment : BaseFragment<SplashScreenVM, SplashScreenBinding>(R.layout.splash_screen) {

    override val viewModel: SplashScreenVM by viewModels()

    override fun onEvent(event: Event) {
        super.onEvent(event)
        when (event) {
            SplashScreenEvent.TimerEndEvent -> {
                val action = SplashScreenFragmentDirections.actionSplashScreenFragmentToChoiceScreenFragment()
                val extras = FragmentNavigatorExtras(binding.logoImage to "logoImage")
                router.navigate(action, extras)
            }
        }
    }
}