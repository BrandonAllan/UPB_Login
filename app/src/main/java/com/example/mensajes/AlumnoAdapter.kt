package com.example.mensajes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AlumnoAdapter: RecyclerView.Adapter<AlumnoAdapter.AlumnoViewHolder>()  {

    var alumno = listOf<Alumno>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AlumnoViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.alumno_item, parent, false)
        return  AlumnoViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlumnoViewHolder, position: Int) {
        val alumno = alumno[position]
        holder.bind(alumno)
    }

    override fun getItemCount(): Int {
        return alumno.size
    }

    class AlumnoViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val nombre: TextView = view.findViewById(R.id.nombre)
        val apellido: TextView = view.findViewById(R.id.apellido)

        fun bind(alumno: Alumno) {
            nombre.text = alumno.nombre
            apellido.text = alumno.apellido
        }
    }
}