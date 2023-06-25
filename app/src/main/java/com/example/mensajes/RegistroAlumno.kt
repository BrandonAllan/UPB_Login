package com.example.mensajes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegistroAlumno : AppCompatActivity() {
    private lateinit var vm: AlumnoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_alumno)

        val text1 = findViewById<EditText>(R.id.editTextText3)
        val text2 = findViewById<EditText>(R.id.editTextText4)
        val button = findViewById<Button>(R.id.button2)
        vm = ViewModelProviders.of(this)[AlumnoViewModel::class.java]

        button.setOnClickListener {
            if (!text1.text.toString().isEmpty() && !text2.text.toString().isEmpty()) {
                CoroutineScope(Dispatchers.IO).launch {
                    vm.agregar(Alumno(0, text1.text.toString(), text2.text.toString()))
                }
                finish()
            } else {
                Toast.makeText(this, "Ingrese todos los datos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}