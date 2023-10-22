package com.msd5.pushpeers.ui.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.msd5.pushpeers.R
import com.msd5.pushpeers.databinding.ActivityAssesmentResultBinding

class AssesmentResultActivity : AppCompatActivity() {

    private lateinit var binding:ActivityAssesmentResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAssesmentResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            startActivity(Intent(this@AssesmentResultActivity,DashboardActivity::class.java))
        }

    }
}