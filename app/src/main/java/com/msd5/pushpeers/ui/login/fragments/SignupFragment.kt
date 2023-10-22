package com.msd5.pushpeers.ui.login.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.msd5.pushpeers.R
import com.msd5.pushpeers.databinding.FragmentSignupBinding


class SignupFragment : Fragment(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

     lateinit var binding: FragmentSignupBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_signup, container, false)

        binding = FragmentSignupBinding.bind(view)

        binding.btnSignup.setOnClickListener(this)
        binding.btnLogin.setOnClickListener(this)



        return view
    }

    override fun onClick(v: View?) {
        when(v){
            binding.btnSignup ->{

            }
            binding.btnLogin ->{

            }
        }
    }
}