package com.example.practica_2.dao

import androidx.room.*
import com.example.practica_2.models.Clinicas


@Dao
interface ClinicasDao {

    @Query( "SELECT * FROM Clinicas")
    fun getAll():List<Clinicas>

    @Query( "SELECT * FROM Clinicas WHERE idClinica = :id")
    fun getById(id:Long):Clinicas

    @Query( "SELECT * FROM Clinicas WHERE tipo LIKE '%' || :clinica  || '%' OR lugar LIKE '%' || :clinica || '%' ")
    fun getByName(clinica:String):List<Clinicas>

    @Insert
    fun insert(clinicas:List<Clinicas>):List<Long>

    @Update
    fun updated(clinicas:Clinicas):Int

    @Delete
    fun delete(clinicas:Clinicas):Int
}