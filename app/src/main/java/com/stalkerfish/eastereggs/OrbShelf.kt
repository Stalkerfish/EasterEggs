package com.stalkerfish.eastereggs

object OrbShelf {
    private val orbsList = ArrayList<Orb>()

    fun getOrbs(): ArrayList<Orb>{
        return orbsList
    }

    fun getOrbsSize(): Int {
        return orbsList.size
    }

    fun addOrb(orb: Orb) {
        orbsList.add(orb)
    }

    fun removeOrb(orb: Orb) {
        orbsList.remove(orb)
    }

    fun eraseShelf(){
        orbsList.clear()
    }
}