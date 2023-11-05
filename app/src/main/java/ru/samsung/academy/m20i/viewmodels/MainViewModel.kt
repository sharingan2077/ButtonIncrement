package ru.samsung.academy.m20i.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.samsung.academy.m20i.Constants
import ru.samsung.academy.m20i.model.Count
import ru.samsung.academy.m20i.repository.CountRepository

class MainViewModel(private val countRepository: CountRepository) : ViewModel() {

    private var count = MutableLiveData<Count>()
    val countText : LiveData<Count>
        get() { return count }

    fun getCount() {
        viewModelScope.launch() {
            var count : Count? = countRepository.getCount()
            if (count == null) {
                count = Count(1, 0)
                countRepository.insertCount(count)
            }
            this@MainViewModel.count.value = count
        }
    }


    fun incrementCount() {
        viewModelScope.launch {
            count.postValue(countRepository.incrementCount(count.value!!))
        }
    }
    fun resetCount() {
        viewModelScope.launch {
            count.postValue(countRepository.resetCount(count.value!!))
        }
    }

    fun deleteCount() =
        viewModelScope.launch {
            countRepository.deleteCount()
        }

}