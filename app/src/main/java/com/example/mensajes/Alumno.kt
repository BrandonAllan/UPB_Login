package com.example.mensajes

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.PropertyKey

@Entity
data class Alumno(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @NonNull @ColumnInfo(name = "nonbre") val nombre: String,
    @NonNull @ColumnInfo(name = "apellido") val apellido: String
)