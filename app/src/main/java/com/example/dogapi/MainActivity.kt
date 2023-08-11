package com.example.dogapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dogapi.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.randomDog.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_layout, RandomDogFragment()).commit()

            binding.randomDog.isClickable = false
            binding.dog10.isClickable = false
        }
    }
}