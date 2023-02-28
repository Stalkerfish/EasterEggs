/* This Room will be everything related to The Earth Planet */

package com.stalkerfish.eastereggs

import android.os.Bundle
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class EarthRoom: AppCompatActivity() {
    private var inventoryBtn: LinearLayout? = null
    private var todaysElementBtn: CardView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        @Suppress("DEPRECATION")
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.earth_room)

        inventoryBtn = findViewById(R.id.inventory)
        todaysElementBtn = findViewById(R.id.todays_element)

        inventoryBtn?.setOnClickListener {
            val inventoryDialog = EarthInventory()
            inventoryDialog.show(supportFragmentManager, inventoryDialog.tag)
        }

        todaysElementBtn?.setOnClickListener {
            val todaysDialog = TodayElement()
            todaysDialog.show(supportFragmentManager, todaysDialog.tag)
        }
    }
}