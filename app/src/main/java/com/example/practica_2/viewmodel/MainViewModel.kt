package com.example.practica_2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practica_2.config.ClinicasApp.Companion.db
import com.example.practica_2.models.Clinicas
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {
    val clinicasList = MutableLiveData<List<Clinicas>>()
    var parametroBusqueda = MutableLiveData<String>()

    fun iniciar() {
        viewModelScope.launch {
            clinicasList.value = withContext(Dispatchers.IO){
                db.clinicasDao().getAll()
            }
        }
    }

    fun buscarPersonal() {
        viewModelScope.launch {
            clinicasList.value = withContext(Dispatchers.IO){
                db.clinicasDao().getByName(parametroBusqueda.value!!)
            }
        }
    }
}