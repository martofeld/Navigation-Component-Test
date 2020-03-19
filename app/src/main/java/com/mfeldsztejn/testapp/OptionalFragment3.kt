package com.mfeldsztejn.testapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.mfeldsztejn.testapp.navigation.NavigationManager
import kotlinx.android.synthetic.main.main_fragment.*

class OptionalFragment3 : BaseFragment(R.layout.main_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        message.text = "$this"

        goto2.setOnClickListener {
            NavigationManager.onStepFinished(requireContext())
        }
    }
}
