package com.msd5.pushpeers.ui.shop

import com.msd5.pushpeers.base.BaseViewModel
import com.msd5.pushpeers.network.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShopVM @Inject
constructor(
    private val apiRepository: ApiRepository,
) : BaseViewModel<ShopContracts>() {

    fun initThings() {
        viewInteractor?.setUpObserver()
        viewInteractor?.setUpView()
    }

    fun onBackClick() {
        viewInteractor?.finishScreen()
    }

}