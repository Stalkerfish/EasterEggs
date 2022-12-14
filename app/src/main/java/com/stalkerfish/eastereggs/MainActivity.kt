package com.stalkerfish.eastereggs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    private var introText: TextView? = null
    private var brewButton: Button? = null
    private var counter: TextView? = null
    private var killButton: Button? = null
    private var hellGateButton: Button? = null

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

        counter?.text = "0"

        brewButton?.setOnClickListener{
            brewCounter++
            killButton?.isVisible = true
            counter?.text = brewCounter.toString()
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