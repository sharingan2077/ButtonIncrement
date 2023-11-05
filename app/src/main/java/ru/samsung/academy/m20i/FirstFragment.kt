package ru.samsung.academy.m20i

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.samsung.academy.m20i.databinding.FragmentFirstBinding
import ru.samsung.academy.m20i.di.AppContainer
import ru.samsung.academy.m20i.di.MyApplication
import ru.samsung.academy.m20i.viewmodels.MainViewModel

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var mainViewModel : MainViewModel
    private lateinit var appContainer: AppContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFirstBinding.inflate(inflater)
        initView()
        initViewModel()
        return binding.root
    }
    private fun initViewModel() {
        appContainer = (activity?.application as MyApplication).appContainer
        mainViewModel = ViewModelProvider(this, appContainer.mainViewModelFactory)[MainViewModel::class.java]
        mainViewModel.countText.observe(viewLifecycleOwner) {
            binding.count.text = it.number.toString()
        }
        mainViewModel.getCount()
    }

    private fun initView() {
        binding.buttonIncrement.setOnClickListener {
            mainViewModel.incrementCount()
        }
    }
}