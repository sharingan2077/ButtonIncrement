package ru.samsung.academy.m20i.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import ru.samsung.academy.m20i.repository.CountRepository
import java.lang.IllegalArgumentException


class MainViewModelFactory(private val countRepository: CountRepository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(countRepository) as T
        }
        else throw IllegalArgumentException("No ViewModels")
    }

}