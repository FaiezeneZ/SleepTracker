package com.example.sleeptracker

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sleep_table")
data class Sleep (
    @ColumnInfo(name = "date") val date: String?,
    @ColumnInfo(name = "hours") val hour : String?,
    @PrimaryKey(autoGenerate = true) val id : Long = 0,
    )
{}