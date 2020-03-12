package com.mfeldsztejn.testapp

import androidx.annotation.NavigationRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object NavigationManager {

    private val mutableNavigationLiveData =
        MutableLiveData<Int>(R.navigation.step1_navigation_graph)

    val navigationLiveData: LiveData<Int>
        get() = mutableNavigationLiveData

    fun postNavigationGraph(@NavigationRes graph: Int) {
        mutableNavigationLiveData.value = graph
    }

}