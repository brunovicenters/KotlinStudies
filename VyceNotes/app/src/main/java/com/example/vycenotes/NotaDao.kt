package com.example.vycenotes

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query



@Dao
interface NotaDao {

    @Insert
    fun insert(nota: Nota)

    @Query("SELECT * FROM Nota")
    fun getAll(): List<Nota>
}