package com.example.practica_2.dao

import androidx.room.*
import com.example.practica_2.models.Clinicas


@Dao
interface ClinicasDao {

    @Query( "SELECT * FROM Clinicas")
    fun getAll():List<Clinicas>

    @Insert
    fun insert(clinicas:List<Clinicas>):List<Long>

    @Update
    fun updated(clinicas:Clinicas):Int

    @Delete
    fun delete(clinicas:Clinicas):Int
}