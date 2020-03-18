package com.mfeldsztejn.testapp.navigation

import android.content.Context
import androidx.annotation.IdRes
import androidx.annotation.NavigationRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mfeldsztejn.testapp.R

object NavigationManager {

    private var nextStep = 0
    private var currentNavigationOption: NavigationOptions? = null
    private val mutableNavigationLiveData = MutableLiveData<NavigationUpdate>()

    val navigationLiveData: LiveData<NavigationUpdate>
        get() = mutableNavigationLiveData

    fun postNavigationOption(option: NavigationOptions) {
        currentNavigationOption = option
        nextStep = 0
        mutableNavigationLiveData.value =
            NavigationUpdate.GraphReplacement(
                R.navigation.navigation_graph
            )
    }

    fun onStepFinished(context: Context) {
        currentNavigationOption?.let {
            val nextStep = context.resources.getIdentifier(
                it.nextSteps[nextStep],
                "id",
                context.packageName
            )
            mutableNavigationLiveData.value =
                NavigationUpdate.GlobalAction(
                    nextStep
                )
            NavigationManager.nextStep++
            if (NavigationManager.nextStep == it.nextSteps.size) NavigationManager.nextStep = 0 // Make it circular
        }
    }

    fun onStepAborted() {
        nextStep--
        if (nextStep < 0) nextStep = 0
    }
}

sealed class NavigationUpdate {
    data class GraphReplacement(@NavigationRes val graph: Int) : NavigationUpdate()
    data class GlobalAction(@IdRes val action: Int) : NavigationUpdate()
}