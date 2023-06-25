package com.example.mensajes

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

@Database(entities = [Alumno::class], version = 2)
abstract class AlumnoDataBase: RoomDatabase() {

    abstract fun alumnoDao(): AlumnoDao

    companion object {
        @Volatile
        private var INSTANCE: AlumnoDataBase? = null

        @Synchronized
        fun getDatabase(context: Context): AlumnoDataBase {
            return INSTANCE?: synchronized(this) {
                val idb = Room.databaseBuilder(
                    context,
                    AlumnoDataBase::class.java,
                    "upb_database"
                ).fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build()

                INSTANCE = idb

                idb
            }
        }

        private val roomCallback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                alumnoDatabase(INSTANCE!!)
            }
        }

        private fun alumnoDatabase(db: AlumnoDataBase) {
            val dao = db.alumnoDao()

            CoroutineScope(IO).launch {
                //dao.agregar(Alumno(1, "pablo", "perez"))
            }
        }
    }
}