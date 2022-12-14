package com.stalkerfish.eastereggs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var introText: TextView? = null
    private var brewButton: Button? = null
    private var counter: TextView? = null
    private var killButton: Button? = null

    var brewCounter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        introText = findViewById(R.id.intro)
        brewButton = findViewById(R.id.brew_button)
        counter = findViewById(R.id.counter)
        killButton = findViewById(R.id.kill_button)

        counter?.text = "0"

        brewButton?.setOnClickListener{
                brewCounter++
                counter?.text = brewCounter.toString()
        }

        killButton?.setOnClickListener {
            if (brewCounter > 0) {
                brewCounter--
                counter?.text = brewCounter.toString()

            }else
                Toast.makeText(this, "There is no one to kill, asshole", Toast.LENGTH_SHORT).show()
        }
    }
}