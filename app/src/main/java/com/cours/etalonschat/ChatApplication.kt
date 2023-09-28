package com.cours.etalonschat

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class ChatApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        //Desactiver le mode night
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}