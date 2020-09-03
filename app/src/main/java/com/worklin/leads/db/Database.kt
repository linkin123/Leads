package com.worklin.leads.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.worklin.leads.leadsModule.models.Lead
import com.worklin.leads.registro.model.Chef

@Database(
    entities = arrayOf(Lead::class)
    , version = 1, exportSchema = false
)
abstract class LocalDatabase : RoomDatabase() {

    abstract val leadsDao: LeadsDao

    companion object {
        @Volatile
        private var INSTANCE: LocalDatabase? = null
        fun getInstance(context: Context): LocalDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        LocalDatabase::class.java,
                        "leads_history_database"
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}