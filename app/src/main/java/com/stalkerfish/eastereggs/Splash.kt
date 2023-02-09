package com.stalkerfish.eastereggs

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class Splash : AppCompatActivity() {
    var githubIcon: ImageView? = null
    var twitterIcon: ImageView? = null
    var instagramIcon: ImageView? = null

    private val myGithub: String = "https://github.com/Stalkerfish/EasterEggs"
    private val myTwitter: String = "https://twitter.com/StalkerFish2"
    private val myInstagram: String = "https://www.instagram.com/stalkerfish_3/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if (!isAppInforegrounded()){
            TODO()
        }


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

    fun isAppInforegrounded() : Boolean {
        val appProcessInfo =  ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(appProcessInfo);
        return (appProcessInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND ||
                appProcessInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_VISIBLE)
    }

    override fun onDestroy() {
        //stop service and stop music
        stopService(Intent(this, SoundService::class.java))
        super.onDestroy()
    }
}