package com.stalkerfish.eastereggs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var introText: TextView? = null
    private var brewButton: Button? = null
    private var counter: TextView? = null

    var brewCounter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        introText = findViewById(R.id.intro)
        brewButton = findViewById(R.id.brew_button)
        counter = findViewById(R.id.counter)

        counter?.text = "0"

        brewButton?.setOnClickListener{
            brewCounter++
            counter?.text = brewCounter.toString()
        }
    }
}