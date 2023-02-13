package com.stalkerfish.eastereggs

import android.content.Context
import android.content.Intent

class WardrobeHelper(private val context: Context, Orb: Class<*>): WardrobeHolder(){
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