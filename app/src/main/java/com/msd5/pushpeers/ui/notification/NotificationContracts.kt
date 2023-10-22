package com.msd5.pushpeers.ui.notification

import com.msd5.pushpeers.base.ViewInteractor

interface NotificationContracts : ViewInteractor {
    fun setUpObserver()
    fun finishScreen()
    fun setData()
    fun setUpView()
}