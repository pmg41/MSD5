package com.msd5.pushpeers.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.msd5.pushpeers.base.BaseActivity
import com.msd5.pushpeers.databinding.ActivityLoginBinding
import com.msd5.pushpeers.ui.dashboard.DashboardActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding, LoginVM>(), LoginContracts {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.viewInteractor = this
        viewModel.initThings()
    }

    override val viewModel: LoginVM by viewModels()

    @Override
    override fun setBinding(layoutInflater: LayoutInflater): ActivityLoginBinding {
        return ActivityLoginBinding.inflate(layoutInflater)
    }

    @Override
    override fun setUpObserver() {

    }

    @Override
    override fun setUpView() {
        binding.run {
            btnLogin.setOnClickListener {
                val intent =DashboardActivity.getIntent(this@LoginActivity)
                startActivity(intent)
            }
            btnSignup.setOnClickListener {
                startActivity(Intent(this@LoginActivity,SignupActivity::class.java))
            }

        }
    }

    @Override
    override fun finishScreen() {
        finish()
    }

    @Override
    override fun setData() {

    }

}