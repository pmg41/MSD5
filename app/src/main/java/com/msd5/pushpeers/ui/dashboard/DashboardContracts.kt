package com.msd5.pushpeers.ui.dashboard

import com.msd5.pushpeers.base.ViewInteractor

interface DashboardContracts : ViewInteractor {
    fun setUpObserver()
    fun finishScreen()
    fun setData()
    fun setUpView()
    fun setUpRecyclerView()
}