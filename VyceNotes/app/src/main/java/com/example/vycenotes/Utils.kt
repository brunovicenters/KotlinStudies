package com.example.vycenotes

import android.content.Context
import androidx.room.Room

fun getDb(context: Context) = Room.databaseBuilder(context, NotaDatabase::class.java, "notas")
    .build()