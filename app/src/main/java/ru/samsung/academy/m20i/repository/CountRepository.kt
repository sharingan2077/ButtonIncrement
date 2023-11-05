package ru.samsung.academy.m20i.repository

import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import ru.samsung.academy.m20i.Constants
import ru.samsung.academy.m20i.db.CountDao
import ru.samsung.academy.m20i.db.CountDatabase
import ru.samsung.academy.m20i.model.Count

class CountRepository(private val countDao: CountDao) {

    suspend fun getCount() : Count? {
        return countDao.getCount()
    }

    suspend fun insertCount(count: Count) {
        countDao.insertCount(count)
    }

    suspend fun incrementCount(count : Count) : Count {
        count.number += 1
        countDao.incrementCount(count)
        return count
    }

    suspend fun deleteCount() : Int {
        return countDao.deleteCount()
    }
}