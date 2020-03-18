package com.mfeldsztejn.testapp

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.mfeldsztejn.testapp.navigation.NavigationManager
import com.mfeldsztejn.testapp.navigation.NavigationOptions
import com.mfeldsztejn.testapp.navigation.NavigationUpdate
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        spinner.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.step_options,
            android.R.layout.simple_spinner_item
        )
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                onItemSelected(parent, null, 0, 0)
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (position) {
                    0 -> NavigationOptions.OPTION_1_2_3
                    1 -> NavigationOptions.OPTION_3_2_1
                    2 -> NavigationOptions.OPTION_2_3_1
                    else -> NavigationOptions.OPTION_1_2_3
                }
                    .also { NavigationManager.postNavigationOption(it) }
            }

        }

        NavigationManager.navigationLiveData.observe(this, Observer {
            when (it) {
                is NavigationUpdate.GraphReplacement -> findNavController(R.id.navigation_fragment).setGraph(
                    it.graph
                )
                is NavigationUpdate.GlobalAction -> findNavController(R.id.navigation_fragment).navigate(
                    it.action
                )
            }
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val navHostFragment = supportFragmentManager.fragments as? NavHostFragment
        val onBackPressed =
            navHostFragment?.childFragmentManager?.fragments?.last() as? OnBackPressed
        onBackPressed?.onBackPressed()
    }
}
