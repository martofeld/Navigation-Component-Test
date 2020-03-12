package com.mfeldsztejn.testapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment7 : Fragment(R.layout.main_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        message.text = "$this"

        if (MainActivity.useSingleGraph) {
            goto2.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.start_step_3))
        } else {
            goto2.setOnClickListener {
                NavigationManager.postNavigationGraph(R.navigation.step3_navigation_graph)
            }
        }
    }
}
