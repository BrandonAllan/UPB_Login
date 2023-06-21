package com.example.mensajes

import java.io.Serializable

data class Estudiante(
    val id: Int,
    val nombre: String,
    val apellido: String,
    val edad: Int
) : Serializable