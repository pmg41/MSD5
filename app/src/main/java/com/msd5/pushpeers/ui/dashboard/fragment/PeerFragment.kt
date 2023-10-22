package com.msd5.pushpeers.ui.dashboard.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.msd5.pushpeers.base.BaseFragment
import com.msd5.pushpeers.databinding.FragmentPeerBinding
import com.msd5.pushpeers.ui.dashboard.DashboardVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeerFragment : BaseFragment<FragmentPeerBinding, DashboardVM>() {


    override val viewModel: DashboardVM by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {

    }

    private fun setListener() {


//        binding.searchIcon.setOnClickListener {
//            if (binding.searchIcon.isSelected) {
//                binding.edtSearch.makeGone()
//            } else {
//                binding.edtSearch.makeVisible()
//            }
//            binding.searchIcon.isSelected = !binding.searchIcon.isSelected
//        }

    }

    private fun setObserver(search: String) {

    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PeerFragment().apply {
            }
    }

    override fun setBinding(
        layoutInflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPeerBinding {
        return FragmentPeerBinding.inflate(layoutInflater, container, false)
    }

}