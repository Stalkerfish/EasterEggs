/* This is the main room. It is like the player base*/

package com.stalkerfish.eastereggs

import android.os.Bundle
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

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

        wardrobe?.setOnClickListener {
            val dialog = WardrobeShelf()
            dialog.show(supportFragmentManager, dialog.tag)     // Display the dialog
        }

        backpack?.setOnClickListener {
            val dialog = BackpackDialog()
            dialog.show(supportFragmentManager, dialog.tag)
        }

        journal?.setOnClickListener {
            val dialog = JournalDialog()
            dialog.show(supportFragmentManager, dialog.tag)
        }

        phone?.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.home_root, PhoneFragment.newInstance(), "Phone")
                .addToBackStack(null)
                .commit()
        }

        midBtn?.setOnClickListener { orbButtonCallback() }
    }

    private fun orbButtonCallback() {
        val earthOrb = Orb(EarthRoom::class.java, "Earth Orb")

        OrbShelf.addOrb(earthOrb)
    }
}