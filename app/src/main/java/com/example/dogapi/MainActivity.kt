package com.example.dogapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dogapi.databinding.ActivityMainBinding
import com.example.dogapi.fragments.MainFragment


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, MainFragment())
            .commit()
    }
}