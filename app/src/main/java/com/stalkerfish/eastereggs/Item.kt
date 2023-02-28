package com.stalkerfish.eastereggs

import android.content.Context

open class Item {

    open val locus: Class<*>? = null
    open val id: String? = locus?.simpleName

    open fun use(context: Context?){
        TODO()
    }
}
