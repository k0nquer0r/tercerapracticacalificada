package com.failoc.tercerapracticacalificada.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.failoc.tercerapracticacalificada.Model.Dao.NotaDao
import com.failoc.tercerapracticacalificada.Model.Nota

@Database(entities = [Nota::class], version = 1)
abstract class MunicipalidadDataBase: RoomDatabase(){

    abstract fun noteDao(): NotaDao


    companion object {

        private const val DATABASE_NAME = "municipalidad_database"
        @Volatile
        private var INSTANCE: MunicipalidadDataBase? = null

        fun getInstance(context: Context): MunicipalidadDataBase? {
            INSTANCE?: synchronized(this){
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    MunicipalidadDataBase::class.java,
                    DATABASE_NAME
                ).build()
            }
            return INSTANCE
        }
    }
}