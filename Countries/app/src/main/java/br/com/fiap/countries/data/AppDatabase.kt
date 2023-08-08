package br.com.fiap.countries.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

const val TABLE_NAME = "COUNTRY_DATABASE"

@Database(entities = [CountryModel::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun countryDAO(): CountryDAO

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            if(INSTANCE != null) {
                return INSTANCE!!
            } else {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    TABLE_NAME
                ).allowMainThreadQueries() //nao façam isso em casa
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}