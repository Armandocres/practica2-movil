package com.example.practica_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practica_2.adaptador.ClinicasAdapter
import com.example.practica_2.databinding.ActivityMainBinding
import com.example.practica_2.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TODO ENLAZAR EL MNODELO CON EL LIVE DATA
        viewModel = ViewModelProvider(this).get()
        viewModel.iniciar()

        binding.myRecycler.apply { layoutManager = LinearLayoutManager(applicationContext) }

        viewModel.clinicasList.observe(this, Observer {
            binding.myRecycler.adapter = ClinicasAdapter(it)
        })
    }
}