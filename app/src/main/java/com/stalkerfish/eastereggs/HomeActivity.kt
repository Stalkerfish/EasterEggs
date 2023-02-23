package com.stalkerfish.eastereggs

import android.graphics.Typeface
import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.fujiyuu75.sequent.Sequent
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle

class HomeActivity : AppCompatActivity() {
    var wardrobeHelper: WardrobeHelper? = null

    private var introText: TextView? = null
    private var wardrobe: CardView? = null
    private var orbCounter: TextView? = null
    private var orbButton: Button? = null
    private var hellGateButton: Button? = null
    private var grid: GridLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        OrbShelf.eraseShelf()

        wardrobeHelper = WardrobeHelper(this)

        orbCounter?.text = "0"

        introText = findViewById(R.id.intro)
        wardrobe = findViewById(R.id.wardrobe)
        orbCounter = findViewById(R.id.counter)
        orbButton = findViewById(R.id.orb_button)
        grid = findViewById(R.id.grid)

        Sequent.origin(grid).start()

        wardrobe?.setOnClickListener {
            val dialog = WardrobeShelf()
            dialog.show(supportFragmentManager, dialog.tag)

        }

        hellGateButton?.setOnClickListener { wardrobeCallback() }

        orbButton?.setOnClickListener { orbButtonCallback() }
    }

    private fun orbButtonCallback() {
        val hellOrb = HellActivity::class.java

        OrbShelf.addOrb(hellOrb)
        orbCounter?.text = OrbShelf.getOrbsSize().toString()
    }

    private fun wardrobeCallback() {
        try {
            wardrobeHelper!!.onTravel()
            orbCounter?.text = wardrobeHelper?.getOrbsSize().toString()
        }
        catch (_: java.lang.IndexOutOfBoundsException){
            MotionToast.createToast(this, "Wardrobe Failed",
                "YOU DON'T HAVE ANY ORBS!", MotionToastStyle.ERROR,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.SHORT_DURATION,
                Typeface.DEFAULT_BOLD)
        }
    }
}