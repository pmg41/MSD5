package com.msd5.pushpeers.ui.login.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.msd5.pushpeers.R
import com.msd5.pushpeers.databinding.FragmentLoginBinding


class LoginFragment : Fragment(),View.OnClickListener {


    private lateinit var binding:FragmentLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_login, container, false)
        binding = FragmentLoginBinding.bind(view)
        binding.btnLogin.setOnClickListener(this)
        binding.btnSignup.setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        when(v){
            binding.btnLogin ->{

            }
            binding.btnSignup ->{

            }
        }
    }


}