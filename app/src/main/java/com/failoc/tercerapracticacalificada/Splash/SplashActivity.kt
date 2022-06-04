package com.failoc.tercerapracticacalificada.Splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.failoc.tercerapracticacalificada.Home.HomeFragment
import com.failoc.tercerapracticacalificada.MainActivity
import com.failoc.tercerapracticacalificada.R

class SplashActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val actionBar = supportActionBar
        actionBar?.hide()

        Handler(Looper.getMainLooper()).
        postDelayed({

            startActivity(Intent(this, MainActivity::class.java))
            finish()

        }, 6000)

    }

    //Desarrollado por @Frank-Ventura
}