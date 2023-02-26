package com.stalkerfish.eastereggs

data class Orb(
    val locus: Class<*>,
    val id: String = locus.simpleName
)