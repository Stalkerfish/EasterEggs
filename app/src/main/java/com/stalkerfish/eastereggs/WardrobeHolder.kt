package com.stalkerfish.eastereggs

import android.content.Context
import android.content.Intent

interface WardrobeHolder {
    fun onTravel()
    fun onClose(context: Context)
    fun Intent(context: Context): Intent
}
