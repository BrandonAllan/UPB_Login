package com.example.mensajes

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AlumnoDao {
    @Insert
    fun agregar(alumno: Alumno)

    @Query("SELECT * FROM Alumno ORDER BY apellido ASC")
    fun getAlumno(): LiveData<List<Alumno>>

    @Query("SELECT * FROM Alumno WHERE id =:idEstudiante")
    fun alumno(idEstudiante: Int): Alumno
}