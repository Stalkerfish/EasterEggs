package com.stalkerfish.eastereggs

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import nl.dionsegijn.steppertouch.OnStepCallback
import nl.dionsegijn.steppertouch.StepperTouch
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle

class MainActivity : AppCompatActivity() {
    var hellWardrobeHelper: WardrobeHelper? = null

    private var introText: TextView? = null
    private var brewButton: Button? = null
    private var counter: TextView? = null
    private var killButton: Button? = null
    private var hellGateButton: Button? = null
    private var stepperTouch: StepperTouch? = null

    private var brewCounter: Int = 0
    private var killCounter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        introText = findViewById(R.id.intro)
        brewButton = findViewById(R.id.brew_button)
        counter = findViewById(R.id.counter)
        killButton = findViewById(R.id.kill_button)
        hellGateButton = findViewById(R.id.hellGateBtn)
        stepperTouch = findViewById(R.id.stepperTouch)

        stepperTouch?.minValue = 0
        stepperTouch?.sideTapEnabled = true

        stepperTouch?.addStepCallback(object : OnStepCallback {
            override fun onStep(value: Int, positive: Boolean) {
                MotionToast.createToast(this@MainActivity,
                    null, "Oh, you raised a human!",
                    MotionToastStyle.INFO, MotionToast.GRAVITY_BOTTOM,
                    MotionToast.SHORT_DURATION, Typeface.SANS_SERIF )
            }
        })

        counter?.text = "0"

        brewButton?.setOnClickListener{
            /* brewCounter++
            killButton?.isVisible = true
            counter?.text = brewCounter.toString() */
            val hellOrb = HellActivity::class.java
            hellWardrobeHelper = WardrobeHelper(this, hellOrb)
            hellWardrobeHelper!!.onTravel()
            hellWardrobeHelper!!.onClose(this)

        }

        hellGateButton?.setOnClickListener {
            val intent = Intent(this, HellActivity::class.java)
            startActivity(intent);
            finish()
        }

        killButton?.setOnClickListener {
            if (brewCounter > 0) {
                brewCounter--
                counter?.text = brewCounter.toString()
                killCounter++

                when (killCounter) {
                    8 -> { introText?.text = getString(R.string.devilWarning) }
                    9 -> { introText?.text = getString(R.string.secondDevilWarning) }
                    10 -> { hellGateButton?.isVisible = true }
                }

            }else
                Toast.makeText(this, "There is no one to kill, asshole", Toast.LENGTH_SHORT).show()
        }
    }
}