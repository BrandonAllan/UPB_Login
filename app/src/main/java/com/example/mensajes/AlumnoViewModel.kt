package com.example.mensajes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class AlumnoViewModel(app: Application): AndroidViewModel(app) {
    private val alumnoapp = AlumnoApplication(app)
    private val alumnos = alumnoapp.alumnos()

    fun obtenerAlumnos(): LiveData<List<Alumno>> = alumnos
    fun agregar(alumno: Alumno) {
        alumnoapp.agragar(alumno)
    }
}