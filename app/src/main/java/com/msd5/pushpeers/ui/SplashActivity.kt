package com.msd5.pushpeers.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.msd5.pushpeers.R
import com.msd5.pushpeers.databinding.ActivitySplashBinding
import com.msd5.pushpeers.ui.dashboard.DashboardActivity
import com.msd5.pushpeers.ui.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private val SPLASH_SCREEN_TIME: Long = 3000
    lateinit var topAnim: Animation
    lateinit var botAnim: Animation
    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        botAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)
        binding.run {
            imgLogo.animation = topAnim
            tvTitle.animation = botAnim
            tvSubTitle.animation = botAnim
        }
//        AudienceNetworkAds.initialize(this)
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(LoginActivity.getIntent(this))
            finish()
        }, SPLASH_SCREEN_TIME)

    }


}