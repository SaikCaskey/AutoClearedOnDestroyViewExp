package com.example.android.databinding.basicsample.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.android.databinding.basicsample.util.autoCleared

abstract class BaseFragment<T : ViewDataBinding> : Fragment() {

    // region Properties

    protected val navController: NavController by lazy {
        findNavController()
    }

    protected var binding by autoCleared<T>()

    // endregion

    // region Functions

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = DataBindingUtil.inflate<T>(inflater, getLayoutId(), container, false)
        .also { binding = it as T }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    // endregion
}
