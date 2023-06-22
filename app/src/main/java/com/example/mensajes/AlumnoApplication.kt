package com.example.mensajes

import android.app.Application
import androidx.lifecycle.LiveData

class AlumnoApplication(application: Application) {

    private var alumnoDao: AlumnoDao
    private var getAlumno: LiveData<List<Alumno>>

    private val dataBase = AlumnoDataBase.getDatabase(application)

    init {
        alumnoDao = dataBase.alumnoDao()
        getAlumno = alumnoDao.getAlumno()
    }

    fun agragar(alumno: Alumno) {
        alumnoDao.agregar(alumno)
    }

    fun alumnos() : LiveData<List<Alumno>> = getAlumno
}