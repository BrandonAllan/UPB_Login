package com.example.mensajes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var vm: AlumnoViewModel
    lateinit var correo: EditText
    lateinit var contrasena: EditText
    lateinit var entrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var registrar = findViewById<Button>(R.id.btn_entrar)
        val rv = findViewById<RecyclerView>(R.id.alumnbos)

        vm = ViewModelProviders.of(this)[AlumnoViewModel::class.java]

        val adapter = AlumnoAdapter()
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)

        vm.obtenerAlumnos().observe(this, Observer {
            Log.d("TAG", "onCreate: $it")
            adapter.alumno = it
        })

        /*CoroutineScope(Dispatchers.IO).launch {
            vm.agregar(Alumno(0, "pablo", "perez"))
        }*/

        registrar.setOnClickListener {
            val intnet = Intent(this, RegistroAlumno::class.java)
            startActivity(intnet)
        }

    }
}