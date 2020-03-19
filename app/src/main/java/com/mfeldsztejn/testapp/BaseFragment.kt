package com.mfeldsztejn.testapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.mfeldsztejn.testapp.navigation.NavigationManager
import com.mfeldsztejn.testapp.viewmodels.ActivityViewModel

abstract class BaseFragment(@LayoutRes layout: Int) : Fragment(layout), OnBackPressed {
    val viewModel by activityViewModels<ActivityViewModel>()

    protected open fun isFirstStep() = false

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Call super but make sure inheritors cant call this
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onBackPressed() {
        if (isFirstStep()) {
            NavigationManager.onStepAborted()
        }
    }
}