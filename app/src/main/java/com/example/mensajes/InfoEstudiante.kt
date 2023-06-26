package com.example.mensajes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class InfoEstudiante : AppCompatActivity() {

    private lateinit var vm: AlumnoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_estudiante)

        val nombre = findViewById<TextView>(R.id.id_nombre)
        val apellido = findViewById<TextView>(R.id.id_apellido)
        val idEstudiante = intent.extras?.getInt("idEstudiante")

        vm = ViewModelProviders.of(this)[AlumnoViewModel::class.java]

        CoroutineScope(IO).launch {
            val estudiante = vm.alumno(idEstudiante!!.toInt())
            nombre.text = estudiante.nombre
            apellido.text = estudiante.apellido
            Log.d("TAG", "onCreate: $estudiante")
        }

    }
}