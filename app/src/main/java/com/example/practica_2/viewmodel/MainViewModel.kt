package com.example.practica_2.viewmodel

import android.util.Log
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
                /*db.clinicasDao().insert(
                    arrayListOf<Clinicas>(
                    Clinicas(idClinica = 0, "Calle 11", "Oftalmologo", "551478925"),
                    Clinicas(idClinica = 0, "Calle 12", "Emabarazo", "5500005")
                )
                )*/

                db.clinicasDao().getAll()
            }
        }
    }
}