package com.tasnim.chowdhury.newhomepage

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    val currentProgressManageProfile = 60
    val currentProgressVideoResume = 42
    private lateinit var progressBarManageProfile: ProgressBar
    private lateinit var progressBarVideoResume: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //WindowCompat.setDecorFitsSystemWindows(window, false)
//        requestWindowFeature(Window.FEATURE_NO_TITLE)
//        this.window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
//        supportActionBar?.hide()
        //this.window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        setContentView(R.layout.activity_main)

        val marqueeText = findViewById<TextView>(R.id.mainPageMarquee)
        marqueeText.isSelected = true

        this.window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

//        val windowInsetsController =
//            ViewCompat.getWindowInsetsController(window.decorView)
//
//        windowInsetsController?.isAppearanceLightNavigationBars = true

        progressBarManageProfile = findViewById(R.id.profileCompleteProgressBar)
        progressBarVideoResume = findViewById(R.id.videoResumeProgressBar)
        progressBarManageProfile.progress = currentProgressManageProfile
        progressBarVideoResume.progress = currentProgressVideoResume
        progressBarManageProfile.max = 100
        progressBarVideoResume.max = 100

    }

}