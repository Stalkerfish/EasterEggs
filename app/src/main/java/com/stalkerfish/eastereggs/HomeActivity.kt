/* This is the main room. It is like the player base*/

package com.stalkerfish.eastereggs

import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.GridLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.fujiyuu75.sequent.Sequent

class HomeActivity : AppCompatActivity() {
    private var introText: TextView? = null
    private var wardrobe: CardView? = null
    private var orbButton: Button? = null
    private var grid: GridLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        @Suppress("DEPRECATION")
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_home)

        OrbShelf.eraseShelf()   // Erase the list of Orbs on start

        introText = findViewById(R.id.intro)
        wardrobe = findViewById(R.id.wardrobe)
        orbButton = findViewById(R.id.orb_button)
        grid = findViewById(R.id.grid)

        Sequent.origin(grid).start()    // Reveals UI items with a discrete animation

        wardrobe?.setOnClickListener {
            val dialog = WardrobeShelf()
            dialog.show(supportFragmentManager, dialog.tag)     // Display the dialog

        }

        orbButton?.setOnClickListener { orbButtonCallback() }
    }

    private fun orbButtonCallback() {
        val earthOrb = Orb(EarthRoom::class.java, "Earth Orb")

        OrbShelf.addOrb(earthOrb)
    }
}