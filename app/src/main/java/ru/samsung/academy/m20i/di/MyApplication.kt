package ru.samsung.academy.m20i.di

import android.app.Application

class MyApplication : Application() {

    val appContainer : AppContainer by lazy { AppContainer(this) }
}