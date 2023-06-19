package com.example.mensajes

object Estudintes {

    private val estudiantes: MutableList<Estudiante>

    init {
        estudiantes = mutableListOf(
            Estudiante(1, "Pablo", "Perez", 15),
            Estudiante(2, "Pablo2", "Perez2", 25),
            Estudiante(3, "Pablo3", "Perez3", 35),
            Estudiante(4, "Pablo4", "Perez4", 45),
            Estudiante(5, "Pablo5", "Perez5", 55),
        )
    }

    fun getAll(): List<Estudiante> = estudiantes

    fun search(query: String): List<Estudiante> {
        if (query.isBlank())
            return emptyList()

        return estudiantes.filter { estudiantes ->
            val regex = query.toRegex(RegexOption.IGNORE_CASE)
            regex.containsMatchIn(estudiantes.nombre)
        }
    }
}