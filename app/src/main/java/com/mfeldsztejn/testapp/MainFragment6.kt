package com.mfeldsztejn.testapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.mfeldsztejn.testapp.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment6 : Fragment(R.layout.main_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        message.text = "$this"

        goto2.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mainFragment6_to_mainFragment7))
    }
}
