package com.mfeldsztejn.testapp

import android.os.Bundle
import android.view.View
import com.mfeldsztejn.testapp.navigation.NavigationManager
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment7 : BaseFragment(R.layout.main_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        message.text = "$this"

        goto2.setOnClickListener {
            NavigationManager.onStepFinished(requireContext())
        }
    }
}
