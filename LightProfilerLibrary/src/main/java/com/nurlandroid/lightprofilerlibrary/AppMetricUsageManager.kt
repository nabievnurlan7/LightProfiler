package com.nurlandroid.lightprofilerlibrary

import android.content.Context
import android.os.Handler


class AppMetricUsageManager(context: Context) {

    private companion object {
        const val INTERVAL_TIME_IN_SEC = 1L
        const val INITIAL_DELAY = 0L
    }

    private val handler: Handler = Handler()
    private val runnable: Runnable = object : Runnable {
        override fun run() {
            exporters.forEach { it.export() }
            handler.postDelayed(this, INTERVAL_TIME_IN_SEC)
        }
    }

    private val exporters = listOf(
        CpuUsageExporter(context),
//        MemoryUsageExporter(context),
        BatteryUsageExporter(context),
//        NetworkUsageExporter(context)
    )


    fun startCollect() {
        handler.postDelayed(runnable, INTERVAL_TIME_IN_SEC)
    }

    fun stopCollect() {
        exporters.forEach { it.close() }
        handler.removeCallbacks(runnable)
    }
}