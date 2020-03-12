package com.mfeldsztejn.testapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        use_single_graph.setOnCheckedChangeListener { _, isChecked ->
            useSingleGraph = isChecked
            if (isChecked)
                NavigationManager.postNavigationGraph(R.navigation.full_navigation_graph)
            else
                NavigationManager.postNavigationGraph(R.navigation.step1_navigation_graph)
        }

        NavigationManager.navigationLiveData.observe(this, Observer {
            findNavController(R.id.navigation_fragment).setGraph(it)
        })
    }

    companion object {
        var useSingleGraph = false
    }
}
