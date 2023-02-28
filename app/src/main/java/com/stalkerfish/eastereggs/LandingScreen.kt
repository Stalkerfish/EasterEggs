package com.stalkerfish.eastereggs

import android.app.ActivityManager
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator


class LandingScreen : AppCompatActivity() {

    var githubIcon: ImageView? = null
    var twitterIcon: ImageView? = null
    var instagramIcon: ImageView? = null
    var startButton: Button? = null
    var worms: WormDotsIndicator? = null


    val myGithub: String = "https://github.com/Stalkerfish/EasterEggs"
    val myTwitter: String = "https://twitter.com/StalkerFish2"
    val myInstagram: String = "https://www.instagram.com/stalkerfish_3/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        @Suppress("DEPRECATION")
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_landing)

        if (!isAppInforegrounded()) {
            TODO()
        }

        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        worms = findViewById(R.id.worm_dots_indicator)

        val views = listOf(R.id.media, R.id.start)

        viewPager.adapter = ViewPagerAdapter(views)
        worms?.attachTo(viewPager)
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