package com.example.rehberuygulamasi.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.rehberuygulamasi.data.entity.Kisiler

@Dao
interface KisilerDao {
    @Query("SELECT * FROM kisiler")
    suspend fun kisileriYukle() : List<Kisiler>

    @Insert
    suspend fun kaydet(kisi: Kisiler)
}