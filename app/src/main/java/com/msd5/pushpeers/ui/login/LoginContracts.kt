package com.msd5.pushpeers.ui.login

import com.msd5.pushpeers.base.ViewInteractor

interface LoginContracts : ViewInteractor {
    fun setUpObserver()
    fun finishScreen()
    fun setData()
    fun setUpView()
}