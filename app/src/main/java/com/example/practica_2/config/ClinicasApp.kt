package com.example.practica_2.config

import android.app.Application
import androidx.room.Room

class ClinicasApp:Application() {
    companion object{
        lateinit var db:ClinicasDb
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            this,
            ClinicasDb::class.java,
            "clinicas",
        ).build()
    }
}