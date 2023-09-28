package com.cours.etalonschat.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.cours.etalonschat.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Duree d'attente et redirection
        Handler(Looper.getMainLooper()).postDelayed(
            {
                Intent(this,AuthentificationActivity::class.java).also{
                   startActivity(it)
               }
            finish()
        },3000)
    }
}