package com.andre.guryanov.cryptoapptest.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.andre.guryanov.cryptoapptest.R

object ActivityCompanion {

    fun launchCoinDetailFragment(activity: FragmentActivity, fromSymbol: String) {
        val containerId = R.id.fragment_container
        val fragment = CoinDetailFragment.newInstance(fromSymbol)
        launchFragment(activity, containerId, fragment)
    }

    private fun launchFragment(activity: FragmentActivity, containerId: Int, fragment: Fragment) {
        activity.supportFragmentManager.popBackStack()
        activity.supportFragmentManager
            .beginTransaction()
            .replace(containerId, fragment)
            .addToBackStack(null)
            .commit()
    }
}