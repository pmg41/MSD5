package com.msd5.pushpeers.ui.notification

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.msd5.pushpeers.base.BaseActivity
import com.msd5.pushpeers.databinding.ActivityNotificationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationActivity : BaseActivity<ActivityNotificationBinding, NotificationVM>(),
    NotificationContracts {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, NotificationActivity::class.java)
        }
    }

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.viewInteractor = this
        viewModel.initThings()
    }

    override val viewModel: NotificationVM by viewModels()

    @Override
    override fun setBinding(layoutInflater: LayoutInflater): ActivityNotificationBinding {
        return ActivityNotificationBinding.inflate(layoutInflater)
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