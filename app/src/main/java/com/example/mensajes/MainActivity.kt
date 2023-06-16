package com.example.mensajes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.tabs.TabLayout.TabGravity
import kotlin.math.log

class MainActivity : AppCompatActivity(), OnClickListener {

    lateinit var correo: EditText
    lateinit var contrasena: EditText
    lateinit var entrar: Button
    
    lateinit var siguiente: Button
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        verificar()
        initViews()
    }
    
    
    
    
    
    fun initViews(){
        siguiente = findViewById(R.id.btn_siguiente)
        siguiente.setOnClickListener(this)
    }

    fun initView() {
        correo = findViewById(R.id.et_correo)
        contrasena = findViewById(R.id.et_contrasena)
        entrar = findViewById(R.id.btn_entrar)
    }

    fun verificar() {
        entrar.setOnClickListener {
            val toast = Toast.makeText(this,"verificar",Toast.LENGTH_SHORT)
            toast.show()
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

    override fun onClick(v: View?) {
        Log.d(TAG, "Siguiente pantalla")
    }
}