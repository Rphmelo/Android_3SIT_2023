package br.com.fiap.mymusiclibrary.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MusicDao {

    @Query("SELECT * FROM musicTable")
    fun selectAll(): List<MusicModel>

    @Query("SELECT * FROM musicTable WHERE favorite == :isFavorite")
    fun selectBy(isFavorite: Boolean): List<MusicModel>

    @Insert
    fun insert(model: MusicModel)
}