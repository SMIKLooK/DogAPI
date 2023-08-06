package com.example.dogapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dogapi.call.Callhttp
import com.example.dogapi.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso


private lateinit var binding: ActivityMainBinding
private lateinit var imageLoader: Callhttp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        imageLoader = Callhttp() { imageUrl ->
            Picasso.get().load(imageUrl).into(binding.commonImage)
        }

        binding.randomButton.setOnClickListener {
            imageLoader.loadImage()
        }
    }
}