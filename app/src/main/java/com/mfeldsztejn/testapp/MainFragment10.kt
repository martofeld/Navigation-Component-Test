package com.mfeldsztejn.testapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment10 : Fragment(R.layout.main_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        message.text = "$this"

//        NavigationManager.postNavigationGraph(R.navigation.full_navigation_graph)
        goto2.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.start_step_1))
    }
}
