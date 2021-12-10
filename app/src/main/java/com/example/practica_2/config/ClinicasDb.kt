package com.example.practica_2.config

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.practica_2.dao.ClinicasDao
import com.example.practica_2.models.Clinicas

@Database(
    entities = [Clinicas::class],
    version = 1
)
abstract class ClinicasDb:RoomDatabase() {
    abstract fun clinicasDao():ClinicasDao
}