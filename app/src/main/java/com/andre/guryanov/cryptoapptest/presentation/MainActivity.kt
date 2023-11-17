package com.andre.guryanov.cryptoapptest.presentation

import android.app.ActivityManager
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.andre.guryanov.cryptoapptest.R
import com.andre.guryanov.cryptoapptest.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val orientation by lazy {
        resources.configuration.orientation
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        showOrHideDetailContainer()

        supportFragmentManager.addOnBackStackChangedListener {
            showOrHideDetailContainer()
        }
    }

    private fun showOrHideDetailContainer() {
        if (orientation == Configuration.ORIENTATION_PORTRAIT) return
        binding.fragmentContainer.visibility =
            if (supportFragmentManager.backStackEntryCount < 1) View.GONE
            else View.VISIBLE
    }


}