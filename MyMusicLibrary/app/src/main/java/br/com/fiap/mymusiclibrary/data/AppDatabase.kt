package br.com.fiap.mymusiclibrary.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

const val TABLE_NAME = "TASK_DATABASE"

@Database(entities = [MusicModel::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun musicDao(): MusicDao

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

                val musicList = listOf(
                    MusicModel(
                        title = "Believer",
                        artist = "Imagine Dragons",
                        favorite = true
                    ),
                    MusicModel(
                        title = "Californication",
                        artist = "Red Hot Chilli Peppers",
                        favorite = false
                    ),
                    MusicModel(
                        title = "Gravity",
                        artist = "John Mayer",
                        favorite = true
                    ),
                    MusicModel(
                        title = "Wonderwall",
                        artist = "Oasis",
                        favorite = false
                    )
                )

                if(INSTANCE?.musicDao()?.selectAll()?.isEmpty() == true) {
                    musicList.forEach {
                        INSTANCE?.musicDao()?.insert(it)
                    }
                }
                return instance
            }
        }
    }
}