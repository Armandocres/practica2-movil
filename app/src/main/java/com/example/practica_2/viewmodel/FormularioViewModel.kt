package com.example.practica_2.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practica_2.config.ClinicasApp.Companion.db
import com.example.practica_2.config.Constantes
import com.example.practica_2.models.Clinicas
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FormularioViewModel:ViewModel() {
    var id = MutableLiveData<Long>()
    var clinica = MutableLiveData<String>()
    var lugar = MutableLiveData<String>()
    var numero = MutableLiveData<String>()
    var operacion = Constantes.OPERACION_INSERTAR
    var operacionExitosa = MutableLiveData<Boolean>()

    init {
        numero.value = "551478914".toString()
    }

    fun guardarUsuario() {
        var mClinicas = Clinicas(0, clinica.value!!, lugar.value!!, numero.value!!)
        when(operacion){
            Constantes.OPERACION_INSERTAR->{
              viewModelScope.launch {
                  val result = withContext(Dispatchers.IO){
                      db.clinicasDao().insert(
                          arrayListOf<Clinicas>(mClinicas)
                      )
                  }
                  operacionExitosa.value = result.isNotEmpty()
              }
            }
            Constantes.OPERACION_EDITAR->{

            }
        }
    }
}