package br.com.fiap.countries.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

const val COUNTRY_MODEL_TABLE_NAME = "countryTable"
@Entity(tableName = COUNTRY_MODEL_TABLE_NAME)
@Parcelize
data class CountryModel(

    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo val name: String,
    @ColumnInfo val capital: String,
    @ColumnInfo val language: String,
    @ColumnInfo val currency: String,
    @ColumnInfo val location: String,
): Parcelable
