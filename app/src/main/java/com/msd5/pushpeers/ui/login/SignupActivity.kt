package com.msd5.pushpeers.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.msd5.pushpeers.R
import com.msd5.pushpeers.databinding.ActivitySignupBinding
import com.msd5.pushpeers.ui.dashboard.DashboardActivity

class SignupActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.run {

            btnSignup.setOnClickListener {
                startActivity(Intent(this@SignupActivity,DashboardActivity::class.java))
            }
            btnLogin.setOnClickListener {
                startActivity(Intent(this@SignupActivity,LoginActivity::class.java))
            }

        }
    }
}