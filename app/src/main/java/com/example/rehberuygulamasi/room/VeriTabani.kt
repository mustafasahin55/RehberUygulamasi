package com.example.rehberuygulamasi.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rehberuygulamasi.data.entity.Kisiler

@Database(entities = [Kisiler::class], version = 1)
abstract class VeriTabani: RoomDatabase() {
    abstract fun getKisilerDao(): KisilerDao

}