package com.stalkerfish.eastereggs

import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import com.fujiyuu75.sequent.Sequent

class HomeActivity : AppCompatActivity() {
    var hellWardrobeHelper: WardrobeHelper? = null

    private var introText: TextView? = null
    private var wardrobe: CardView? = null
    private var peopleCounter: TextView? = null
    private var killButton: Button? = null
    private var hellGateButton: Button? = null
    private var grid: GridLayout? = null

    private var brewCounter: Int = 0
    private var killCounter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        introText = findViewById(R.id.intro)
        wardrobe = findViewById(R.id.wardrobe)
        peopleCounter = findViewById(R.id.counter)
        killButton = findViewById(R.id.kill_button)
        hellGateButton = findViewById(R.id.hellGateBtn)
        grid = findViewById(R.id.grid)

        Sequent.origin(grid).start()

        peopleCounter?.text = "0"

        wardrobe?.setOnClickListener{
            wardrobeCallback()
        }

        hellGateButton?.setOnClickListener {
            wardrobeCallback()
        }

        killButton?.setOnClickListener {
            killButtonCallback()
        }
    }

    private fun brewCallback() {
        brewCounter++
        killButton?.isVisible = true
        peopleCounter?.text = brewCounter.toString()
    }

    private fun killButtonCallback() {
        if (brewCounter > 0) {
            brewCounter--
            peopleCounter?.text = brewCounter.toString()
            killCounter++

            when (killCounter) {
                8 -> { introText?.text = getString(R.string.devilWarning) }
                9 -> { introText?.text = getString(R.string.secondDevilWarning) }
                10 -> { hellGateButton?.isVisible = true }
            }

        }else
            Toast.makeText(this, "There is no one to kill, asshole", Toast.LENGTH_SHORT).show()
    }

    private fun wardrobeCallback() {
        val hellOrb = HellActivity::class.java
        hellWardrobeHelper = WardrobeHelper(this, hellOrb)
        hellWardrobeHelper!!.onTravel()
        hellWardrobeHelper!!.onClose(this)
    }
}