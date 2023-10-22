package com.msd5.pushpeers.ui.shop

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.msd5.pushpeers.base.BaseActivity
import com.msd5.pushpeers.databinding.ActivityShopBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShopActivity : BaseActivity<ActivityShopBinding, ShopVM>(), ShopContracts {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, ShopActivity::class.java)
        }
    }

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.viewInteractor = this
        viewModel.initThings()
    }

    override val viewModel: ShopVM by viewModels()

    @Override
    override fun setBinding(layoutInflater: LayoutInflater): ActivityShopBinding {
        return ActivityShopBinding.inflate(layoutInflater)
    }

    @Override
    override fun setUpObserver() {

    }

    @Override
    override fun setUpView() {

    }

    @Override
    override fun finishScreen() {
        finish()
    }

    @Override
    override fun setData() {

    }

}