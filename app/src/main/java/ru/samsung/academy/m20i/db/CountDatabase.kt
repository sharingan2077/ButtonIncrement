package ru.samsung.academy.m20i.db

import android.content.Context
import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import ru.samsung.academy.m20i.model.Count

@Database(entities = [Count::class], version = 1)
abstract class CountDatabase : RoomDatabase() {

    abstract fun getCountDao() : CountDao

    companion object {
        @Volatile
        private var INSTANCE : CountDatabase? = null
        fun getInstance(context: Context) : CountDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CountDatabase::class.java,
                        "count_data_base")
                        .build()
                }
                return instance
            }

        }

    }

}