package com.stalkerfish.eastereggs

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

abstract class WardrobeHolder : AppCompatActivity() {

    abstract fun onTravel()
    abstract fun onClose(context: Context)
    abstract fun Intent(context: Context): Intent
}
