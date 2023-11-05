package ru.samsung.academy.m20i.di

import android.content.Context
import androidx.room.Room
import ru.samsung.academy.m20i.db.CountDatabase
import ru.samsung.academy.m20i.repository.CountRepository
import ru.samsung.academy.m20i.viewmodels.MainViewModelFactory

class AppContainer(private var applicationContext: Context) {


    private val countDatabase = CountDatabase.getInstance(applicationContext)

    private val countRepository = CountRepository(countDatabase.getCountDao())

    val mainViewModelFactory = MainViewModelFactory(countRepository)

}