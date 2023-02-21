package com.stalkerfish.eastereggs

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class WardrobeHelper(private val context: Context):
    WardrobeHolder, AppCompatActivity(){

    private val mOrbs = mutableListOf<Class<*>>()

    fun getOrbs(): Int{
        return mOrbs.size
    }

    fun addOrb(Orb: Class<*>){
        mOrbs.add(Orb)
    }

    private fun removeOrb(Orb: Class<*>) {
        mOrbs.remove(Orb)
    }

    override fun Intent(context: Context): Intent {
        return Intent(this, mOrbs[0])
    }

    override fun onTravel() {
        val intent = Intent(context, mOrbs[0])
        context.startActivity(intent);
        removeOrb(mOrbs[0])
        finish()
    }
}