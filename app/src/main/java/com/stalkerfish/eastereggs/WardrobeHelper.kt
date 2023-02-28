package com.stalkerfish.eastereggs

import androidx.appcompat.app.AppCompatActivity

class WardrobeHelper : AppCompatActivity() {

    private val mOrbs = OrbShelf.getOrbs()

    fun getOrbsList(): List<String> {
        return mOrbs.map { it.id }
    }

    fun getOrbsSize(): Int {
        return OrbShelf.getOrbsSize()
    }
}