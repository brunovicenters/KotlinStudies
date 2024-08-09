package com.example.vycenotes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Nota(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var title: String? = "New Note",
    var desc: String,
    // Optional
    @ColumnInfo(name = "signature")
    var user: String
)

