package com.example.mensajes

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var correo: EditText
    lateinit var contrasena: EditText
    lateinit var entrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        verificar()

        if (getDatos()) {
            val intent = Intent(this, ListaEstudiantes::class.java)
            startActivity(intent)
            //Log.d("TAG", "onCreate: sesion")
            //Log.d("TAG", "onCreate: sesion")
        }
    }

    fun initView() {
        correo = findViewById(R.id.et_correo)
        contrasena = findViewById(R.id.et_contrasena)
        entrar = findViewById(R.id.btn_entrar)
    }

    fun verificar() {
        entrar.setOnClickListener {
            if (correo.text.toString().trim() != "tommy.pozo95@gmail.com") {
                preferences(true)

                val intent = Intent(this, ListaEstudiantes::class.java)
                startActivity(intent)
            } else {
                val toast = Toast.makeText(this,"Verifica tu correo",Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }

    override fun onStart() {
        super.onStart()

    }

    override fun onPause() {
        super.onPause()

    }

    override fun onResume() {
        super.onResume()

    }

    override fun onStop() {
        super.onStop()

    }

    override fun onDestroy() {
        super.onDestroy()

    }

    fun preferences(verficar: Boolean) {
        val pref = getSharedPreferences("sesion", Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putBoolean("login", verficar)
        editor.putString("nombre", "Pablo")
        editor.commit()
    }

    fun getDatos(): Boolean {
        val pref = getSharedPreferences("sesion", Context.MODE_PRIVATE)
        return pref.getBoolean("login", false)
    }
}