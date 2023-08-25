package com.example.dogapi.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dogapi.databinding.FragmentDog10Binding
import com.example.dogapi.dog10.Dog10Datasource
import com.example.dogapi.dog10.adapter.Dog10Adapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

class Dog10Fragment : Fragment() {
    private lateinit var binding: FragmentDog10Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDog10Binding.inflate(inflater)
        runBlocking(Dispatchers.Default) {
            val myDataset = Dog10Datasource().loadDog10()

            binding.recyclerView.adapter = Dog10Adapter(myDataset)
        }
        return binding.root
    }
}