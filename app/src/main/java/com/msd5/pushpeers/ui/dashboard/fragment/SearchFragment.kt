package com.msd5.pushpeers.ui.dashboard.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.msd5.pushpeers.base.BaseFragment
import com.msd5.pushpeers.databinding.FragmentSearchBinding
import com.msd5.pushpeers.ui.dashboard.DashboardVM
import com.msd5.pushpeers.utils.makeGone
import com.msd5.pushpeers.utils.makeVisible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding, DashboardVM>() {


    override val viewModel: DashboardVM by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
        setSearchTextWatcher()
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {

    }

    private fun setListener() {


        binding.searchIcon.setOnClickListener {
            if (binding.searchIcon.isSelected) {
                binding.edtSearch.makeGone()
            } else {
                binding.edtSearch.makeVisible()
            }
            binding.searchIcon.isSelected = !binding.searchIcon.isSelected
        }

    }

    private fun setSearchTextWatcher() {
        //search text after min 2 character is entered
        binding.edtSearch.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                if (count >= 2) {
                    setObserver(s.toString())
                }
            }
        })
    }

    private fun setObserver(search: String) {

    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {
            }
    }

    override fun setBinding(
        layoutInflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSearchBinding {
        return FragmentSearchBinding.inflate(layoutInflater, container, false)
    }
    
}