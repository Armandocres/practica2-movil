package com.example.practica_2.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.practica_2.MainActivity
import com.example.practica_2.R
import com.example.practica_2.config.Constantes
import com.example.practica_2.databinding.ActivityFormularioBinding
import com.example.practica_2.viewmodel.FormularioViewModel

class FormularioActivity : AppCompatActivity() {
    lateinit var binding: ActivityFormularioBinding
    lateinit var viewModel: FormularioViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get()
        viewModel.operacion = intent.getStringExtra(Constantes.OPERACION_KEY)!!
        binding.modelo = viewModel
        binding.lifecycleOwner = this

        viewModel.operacionExitosa.observe(this, Observer {
            if(it) {
                mostrarMnesaje("operacion exitosa")
                irAInicio()
            }else {
                mostrarMnesaje("Error")
            }
        })
    }

    private fun mostrarMnesaje(s: String) {
        Toast.makeText(applicationContext,s,Toast.LENGTH_LONG).show()
    }

    private fun irAInicio() {
        val intent = Intent(applicationContext,MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}