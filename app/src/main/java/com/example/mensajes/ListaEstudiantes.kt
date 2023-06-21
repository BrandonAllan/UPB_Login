package com.example.mensajes

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.google.gson.Gson

class ListaEstudiantes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_estudiantes)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val estudiante = Estudiante(
            123,
            "pablo",
            "perez",
            32)
        val jsonEstudiante = Gson().toJson(estudiante)
        preferences("$jsonEstudiante}")
        Log.d("TAG", "onCreate: ${jsonEstudiante}")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        val manager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val textoBuscar = menu?.findItem(R.id.search)?.actionView as SearchView

        textoBuscar.setSearchableInfo(
            manager.getSearchableInfo(componentName)
        )
        textoBuscar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                if(!newText.isNullOrBlank())
                    buscar(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
        })

        menu.findItem(R.id.search)?.setOnActionExpandListener(object :
            MenuItem.OnActionExpandListener {

            override fun onMenuItemActionExpand(item: MenuItem): Boolean {
                buscar("")
                return true
            }

            override fun onMenuItemActionCollapse(item: MenuItem): Boolean {
                setExpensesInitialState()
                return true
            }
        })

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.search) {
            Toast.makeText(this, "Buscar", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setExpensesInitialState() {
        val all = Estudintes.getAll()
    }

    private fun buscar(query: String) {
        val searchResults = Estudintes.search(query)
        Log.d("TAG", "searchExpenses: $searchResults")
    }

    fun preferences(json: String) {
        val pref = getSharedPreferences("sesion", Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putString("estudiante", json)
        editor.commit()
    }
}