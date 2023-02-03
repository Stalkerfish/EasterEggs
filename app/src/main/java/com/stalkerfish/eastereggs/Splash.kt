package com.stalkerfish.eastereggs

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Splash : AppCompatActivity() {
    var githubIcon: ImageView? = null
    var twitterIcon: ImageView? = null
    var instagramIcon: ImageView? = null

    val myGithub: String = "https://github.com/Stalkerfish/EasterEggs"
    val myTwitter: String = "https://twitter.com/StalkerFish2"
    val myInstagram: String = "https://www.instagram.com/stalkerfish_3/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        githubIcon = findViewById(R.id.github)
        twitterIcon = findViewById(R.id.twitter)
        instagramIcon = findViewById(R.id.instagram)

        githubIcon?.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse(myGithub)
            startActivity(openURL)
        }

        twitterIcon?.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse(myTwitter)
            startActivity(openURL)
        }

        instagramIcon?.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse(myInstagram)
            startActivity(openURL)
        }
    }
}