package br.com.fiap.countries.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CountryDAO {

    @Query("SELECT * FROM $COUNTRY_MODEL_TABLE_NAME ORDER BY capital")
    fun select(): List<CountryModel>

    @Insert
    fun insert(countryModel: CountryModel)

    @Update
    fun update(countryModel: CountryModel)


    @Delete
    fun delete(countryModel: CountryModel)

}