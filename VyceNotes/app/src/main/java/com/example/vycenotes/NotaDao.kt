package com.example.vycenotes

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface NotaDao {

    @Insert
    fun insert(nota: Nota)

    @Query("SELECT * FROM Nota")
    fun getAll(): List<Nota>

    @Update
    fun update(nota: Nota)

    @Delete
    fun delete(nota: Nota)
}