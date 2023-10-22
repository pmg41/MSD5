package com.msd5.pushpeers.ui.dashboard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.msd5.pushpeers.R
import com.msd5.pushpeers.base.BaseActivity
import com.msd5.pushpeers.databinding.ActivityDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : BaseActivity<ActivityDashboardBinding, DashboardVM>(),
    DashboardContracts {


    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, DashboardActivity::class.java)
        }
    }

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding.viewModel = viewModel
        viewModel.viewInteractor = this
        viewModel.initThings()
        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment? ?: return

        val navController = host.navController
        setupBottomNavMenu(navController)

    }

    override val viewModel: DashboardVM by viewModels()

    @Override
    override fun setBinding(layoutInflater: LayoutInflater): ActivityDashboardBinding {
        return ActivityDashboardBinding.inflate(layoutInflater)
    }

    @Override
    override fun setUpObserver() {
    }

    @Override
    override fun setUpView() {
        binding.run {

        }
    }

    override fun setUpRecyclerView() {

    }

    @Override
    override fun finishScreen() {
        finish()
    }

    @Override
    override fun setData() {

    }


    private fun setupBottomNavMenu(navController: NavController) {
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        bottomNav?.setupWithNavController(navController)
    }


}