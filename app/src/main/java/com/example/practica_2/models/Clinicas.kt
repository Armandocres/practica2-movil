package com.example.practica_2.models

import androidx.room.PrimaryKey
import androidx.room.Entity

@Entity
data class Clinicas (
    @PrimaryKey(autoGenerate = true)
    val idClinica:Long,
    var lugar:String,
    var tipo:String,
    var contacto:String
)