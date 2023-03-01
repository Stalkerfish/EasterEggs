/* This is the main room. It is like the player base*/

package com.stalkerfish.eastereggs

import android.os.Bundle
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.fujiyuu75.sequent.Sequent

class HomeActivity : AppCompatActivity() {
    private var wardrobe: FrameLayout? = null
    private var backpack: FrameLayout? = null
    private var midBtn: LinearLayout? = null
    private var midBtnTxt: TextView? = null
    private var journal: FrameLayout? = null
    private var phone: FrameLayout? = null
    private var settings: FrameLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        @Suppress("DEPRECATION")
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_home)

        OrbShelf.eraseShelf()   // Erase the list of Orbs on start

        wardrobe = findViewById(R.id.wardrobe)
        backpack = findViewById(R.id.bag)
        midBtn = findViewById(R.id.mid_button)
        midBtnTxt = findViewById(R.id.mid_button_text)
        journal = findViewById(R.id.journal)
        phone = findViewById(R.id.phone)
        settings = findViewById(R.id.settings)

        val row1 = findViewById<LinearLayout>(R.id.first_row)
        val row2 = midBtn
        val row3 = findViewById<LinearLayout>(R.id.last_row)

        Sequent.origin(row1).start()    // Reveals UI items with a discrete animation
        Sequent.origin(row2).start()
        Sequent.origin(row3).start()


        wardrobe?.setOnClickListener {
            val dialog = WardrobeShelf()
            dialog.show(supportFragmentManager, dialog.tag)     // Display the dialog
        }

        midBtn?.setOnClickListener { orbButtonCallback() }
    }

    private fun orbButtonCallback() {
        val earthOrb = Orb(EarthRoom::class.java, "Earth Orb")

        OrbShelf.addOrb(earthOrb)
    }
}