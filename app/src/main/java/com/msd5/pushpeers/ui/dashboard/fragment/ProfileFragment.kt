package com.msd5.pushpeers.ui.dashboard.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.msd5.pushpeers.R
import com.msd5.pushpeers.databinding.FragmentLoginBinding
import com.msd5.pushpeers.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_profile, container, false)
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.bind(view)



        return view
    }


}