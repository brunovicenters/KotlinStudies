package com.example.vycenotes

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Nota::class], version = 1)
abstract class NotaDatabase: RoomDatabase() {
    abstract fun notaDao(): NotaDao
}