package com.stalkerfish.eastereggs

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class WardrobeHelper(private val context: Context):
    WardrobeHolder, AppCompatActivity() {

    private val mOrbs = OrbShelf.getOrbs()

    fun getOrbsList(): List<String> {
        return mOrbs.map { it.id }
    }

    fun getOrbsSize(): Int {
        return OrbShelf.getOrbsSize()
    }

    override fun Intent(context: Context): Intent {
        return Intent(this, mOrbs[0].locus)
    }

    override fun onTravel(orb: Orb) {
        val intent = Intent(context, orb.locus)
        context.startActivity(intent);
        OrbShelf.removeOrb(orb)
        finish()
    }
}