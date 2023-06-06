package com.example.mensajes

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
    }

    fun initView() {
        correo = findViewById(R.id.et_correo)
        contrasena = findViewById(R.id.et_contrasena)
        entrar = findViewById(R.id.btn_entrar)
    }

    fun verificar() {
        entrar.setOnClickListener {
            if (correo.text.toString() == "perez.zpt@gmail.com") {
                val toast = Toast.makeText(this,"Correcto",Toast.LENGTH_SHORT)
                toast.show()
            } else {
                val toast = Toast.makeText(this,"Verifica tu corre",Toast.LENGTH_SHORT)
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
}