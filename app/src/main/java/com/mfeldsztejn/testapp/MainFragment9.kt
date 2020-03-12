package com.mfeldsztejn.testapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment9 : Fragment(R.layout.main_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        message.text = "$this"

        goto2.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mainFragment9_to_mainFragment10))
    }
}
