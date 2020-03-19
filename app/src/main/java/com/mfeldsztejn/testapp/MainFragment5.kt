package com.mfeldsztejn.testapp

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment5 : BaseFragment(R.layout.main_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        message.text = "$this"

        goto2.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mainFragment5_to_mainFragment6))
    }

    override fun isFirstStep(): Boolean = true
}
