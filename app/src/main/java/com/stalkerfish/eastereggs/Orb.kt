package com.stalkerfish.eastereggs

import android.content.Context
import android.content.Intent

data class Orb(
    override val locus: Class<*>,
    override val id: String = locus.simpleName
): Item(), WardrobeHolder{
    override fun use(context: Context?) {
        onTravel(context!!, this)
    }

    override fun onTravel(context: Context, orb: Orb) {
        val intent = Intent(context, orb.locus)
        context.startActivity(intent)
        OrbShelf.removeOrb(orb)
    }
}