package com.failoc.tercerapracticacalificada

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.failoc.tercerapracticacalificada.Home.HomeFragment
import kotlinx.android.synthetic.main.inicio_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inicio_activity)
        Log.v("CICLO_VIDA", "onCreate")

        val actionBar = supportActionBar
        actionBar?.hide()

        openFragment(HomeFragment.newInstance())





    }



        private fun openFragment(fragment: Fragment) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.framelayoutContent, fragment)
            transaction.commit()
        }


        //Desarrollado por @Frank-Ventura
}