package com.stalkerfish.eastereggs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager

class HellActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        @Suppress("DEPRECATION")
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_hell)
    }
}