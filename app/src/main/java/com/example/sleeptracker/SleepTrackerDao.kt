package com.example.sleeptracker

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SleepTrackerDao {
    @Query("SELECT * FROM sleep_table")
    fun getAll(): Flow<List<Sleep>>

    @Insert
    fun insert(sleep: Sleep)

    @Query("DELETE FROM sleep_table")
    fun deleteAll()
}