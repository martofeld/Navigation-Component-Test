package com.mfeldsztejn.testapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment1 : BaseFragment(R.layout.main_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        message.text = "$this"

        goto2.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mainFragment1_to_mainFragment2))
        goto3.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mainFragment1_to_mainFragment3))
    }

    override fun isFirstStep() = true
}
