package com.msd5.pushpeers.ui.dashboard

import com.msd5.pushpeers.base.BaseViewModel
import com.msd5.pushpeers.network.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardVM @Inject
constructor(
    private val apiRepository: ApiRepository,
) : BaseViewModel<DashboardContracts>() {

    fun initThings() {
        viewInteractor?.setUpObserver()
        viewInteractor?.setUpView()
        viewInteractor?.setUpRecyclerView()
    }

    fun onBackClick() {
        viewInteractor?.finishScreen()
    }

//    fun getDashBoardData(): LiveData<Resource<MovieResponse>> {
//        return apiRepository.getDashBoardData()
//    }
//
//    fun getSearchMovieData(search: String): LiveData<Resource<MovieResponse>> {
//        return apiRepository.getSearchMovieData(search)
//    }
}