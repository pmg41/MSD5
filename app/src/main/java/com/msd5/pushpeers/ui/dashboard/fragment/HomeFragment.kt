package com.msd5.pushpeers.ui.dashboard.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.msd5.pushpeers.base.BaseFragment
import com.msd5.pushpeers.databinding.FragmentHomeBinding
import com.msd5.pushpeers.ui.dashboard.DashboardVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment :
    BaseFragment<FragmentHomeBinding, DashboardVM>() /*HomeItemListener,Serializable*/ {


//    private var categoryWiseMovieList = mutableListOf<CategoryModel>()
//
//    @Inject
//    lateinit var movieCategoryAdapter: MovieCategoryAdapter

    override val viewModel: DashboardVM by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        binding.run {

        }
    }


    override fun setBinding(
        layoutInflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater, container, false)
    }

}