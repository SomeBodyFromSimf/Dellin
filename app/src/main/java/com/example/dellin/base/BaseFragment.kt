package com.example.dellin.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.example.dellin.utils.getBinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

abstract class BaseFragment<VM: BaseVM,VB : ViewBinding>(@LayoutRes layoutRes: Int) : Fragment(layoutRes){

    protected val router
        get() = findNavController()

    protected abstract val viewModel: VM

    private var _binding: VB? = null

    protected val binding: VB
        get() = _binding ?: throw RuntimeException("Should only use binding after onCreateView and before onDestroyView")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = getBinding(inflater, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launchWhenStarted { viewModel.tasksEvent.collect { onEvent(it)} }
    }

    open fun onEvent(event: Event) {
        when(event) {
            is LogOffEvent -> {
                //TODO(разавторизация)
            }
    }}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    protected open fun <T:Event> Flow<T>.onEvent(event: (T)-> Unit) {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted { collect { event(it)} }
    }
}