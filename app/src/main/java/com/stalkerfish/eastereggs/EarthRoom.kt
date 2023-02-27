/* This Room will be everything related to The Earth Planet */

package com.stalkerfish.eastereggs

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class EarthRoom: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.earth_room)
    }
}