package ru.samsung.academy.m20i

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import ru.samsung.academy.m20i.databinding.ActivityMainBinding
import ru.samsung.academy.m20i.db.CountDatabase
import ru.samsung.academy.m20i.di.AppContainer
import ru.samsung.academy.m20i.di.MyApplication
import ru.samsung.academy.m20i.repository.CountRepository
import ru.samsung.academy.m20i.viewmodels.MainViewModel
import ru.samsung.academy.m20i.viewmodels.MainViewModelFactory

object Constants {
    const val TAG = "MY_TAG"
}
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolBar)
        initView()


    }

    private fun initView() {
        binding.fab.setOnClickListener {
            Snackbar.make(it, "You click on fab", Snackbar.LENGTH_SHORT).show()
        }
    }
}