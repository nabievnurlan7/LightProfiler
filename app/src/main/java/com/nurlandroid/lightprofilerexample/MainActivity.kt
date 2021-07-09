package com.nurlandroid.lightprofilerexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nurlandroid.lightprofilerlibrary.AppMetricUsageManager

class MainActivity : AppCompatActivity() {
    private lateinit var appMetricUsageManager: AppMetricUsageManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appMetricUsageManager = AppMetricUsageManager(this)
        appMetricUsageManager.startCollect()
    }

    override fun onPause() {
        super.onPause()
        appMetricUsageManager.stopCollect()
    }
}