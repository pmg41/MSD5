package com.msd5.pushpeers.ui.notification

import com.msd5.pushpeers.base.BaseViewModel
import com.msd5.pushpeers.network.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotificationVM @Inject
constructor(
    private val apiRepository: ApiRepository,
) : BaseViewModel<NotificationContracts>() {

    fun initThings() {
        viewInteractor?.setUpObserver()
        viewInteractor?.setUpView()
    }

    fun onBackClick() {
        viewInteractor?.finishScreen()
    }

}