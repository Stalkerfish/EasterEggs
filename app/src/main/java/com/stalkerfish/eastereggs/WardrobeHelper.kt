package com.stalkerfish.eastereggs

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class WardrobeHelper(private val context: Context, Orb: Class<*>): WardrobeHolder,
    AppCompatActivity(){

    private val key = Orb

    override fun Intent(context: Context): Intent {
        return Intent(this, key)
    }

    override fun onTravel() {
        val intent = Intent(context, key)
        context.startActivity(intent);
    }

    override fun onClose(context: Context) {
        finish()
    }
}