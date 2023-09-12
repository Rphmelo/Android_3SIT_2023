package br.com.fiap.mymusiclibrary.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "musicTable")
data class MusicModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo
    val title: String,
    @ColumnInfo
    val artist: String,
    @ColumnInfo
    val favorite: Boolean
)
