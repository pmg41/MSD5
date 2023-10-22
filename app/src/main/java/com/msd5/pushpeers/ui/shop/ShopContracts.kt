package com.msd5.pushpeers.ui.shop

import com.msd5.pushpeers.base.ViewInteractor

interface ShopContracts : ViewInteractor {
    fun setUpObserver()
    fun finishScreen()
    fun setData()
    fun setUpView()
}