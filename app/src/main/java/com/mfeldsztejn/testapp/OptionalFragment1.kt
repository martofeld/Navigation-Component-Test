package com.mfeldsztejn.testapp

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.main_fragment.*

class OptionalFragment1 : BaseFragment(R.layout.main_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        message.text = "$this"

        goto2.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_optionalFragment1_to_optionalFragment2))
    }

    override fun isFirstStep() = true
}
