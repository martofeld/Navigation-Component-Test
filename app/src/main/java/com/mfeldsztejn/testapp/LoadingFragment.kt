package com.mfeldsztejn.testapp

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.fragment.app.Fragment
import com.mfeldsztejn.testapp.navigation.NavigationManager

class LoadingFragment : BaseFragment(R.layout.loading_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        object : CountDownTimer(2000, 1000) {
            override fun onFinish() {
                NavigationManager.onStepFinished(requireContext())
            }

            override fun onTick(millisUntilFinished: Long) {
            }
        }.start()
    }
}