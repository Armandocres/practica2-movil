package com.example.practica_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practica_2.UI.FormularioActivity
import com.example.practica_2.adaptador.ClinicasAdapter
import com.example.practica_2.config.Constantes
import com.example.practica_2.databinding.ActivityMainBinding
import com.example.practica_2.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this).get()
        binding.lifecycleOwner = this
        binding.modelo = viewModel
        viewModel.iniciar()

        binding.myRecycler.apply { layoutManager = LinearLayoutManager(applicationContext) }

        viewModel.clinicasList.observe(this, Observer {
            binding.myRecycler.adapter = ClinicasAdapter(it)
        })

        binding.btnAbrirFormulario.setOnClickListener {
            val intent = Intent(this,FormularioActivity::class.java)
            intent.putExtra(Constantes.OPERACION_KEY,Constantes.OPERACION_INSERTAR)
            startActivity(intent)
        }

        binding.etBuscar.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                if (s.toString().isNotEmpty()) {
                    viewModel.buscarPersonal()
                }
            }

        })
    }
}