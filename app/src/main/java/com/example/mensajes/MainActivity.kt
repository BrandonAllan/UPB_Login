package com.example.mensajes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
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

        vm = ViewModelProviders.of(this)[AlumnoViewModel::class.java]

        vm.obtenerAlumnos().observe(this, Observer {
            Log.d("TAG", "onCreate: $it")
        })

        CoroutineScope(Dispatchers.IO).launch {
            vm.agregar(Alumno(1, "pablo", "perez"))
        }

    }
}