package ru.samsung.academy.m20i.db

import android.util.Log
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.util.getColumnIndex
import kotlinx.coroutines.flow.Flow
import ru.samsung.academy.m20i.Constants
import ru.samsung.academy.m20i.model.Count

@Dao
interface CountDao  {

    @Insert
    suspend fun insertCount(count: Count) : Long

    @Update
    suspend fun incrementCount(count : Count)

    @Query("SELECT * FROM count_table")
    suspend fun getCount() : Count?
    @Query("DELETE FROM count_table")
    suspend fun deleteCount() : Int

}