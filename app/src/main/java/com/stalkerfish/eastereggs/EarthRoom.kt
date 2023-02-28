/* This Room will be everything related to The Earth Planet */

package com.stalkerfish.eastereggs

import android.os.Bundle
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class EarthRoom: AppCompatActivity() {
    private var inventoryBtn: LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        @Suppress("DEPRECATION")
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.earth_room)

        inventoryBtn = findViewById(R.id.inventory)

        inventoryBtn?.setOnClickListener {
            val dialog = EarthInventory()
            dialog.show(supportFragmentManager, dialog.tag)
        }
    }
}