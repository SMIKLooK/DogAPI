package com.example.dogapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import com.example.dogapi.call.Callhttp
import com.example.dogapi.databinding.ActivityMainBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception


private lateinit var binding: ActivityMainBinding
private lateinit var imageLoader: Callhttp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        imageLoader = Callhttp() { imageUrl ->
            Picasso.get().load(imageUrl)
                .into(binding.commonImage, object : Callback{
                    override fun onSuccess() {
                        binding.progressBar.visibility = View.GONE
                        binding.randomButton.isClickable = true
                    }

                    override fun onError(e: Exception?) {
                        binding.progressBar.visibility = View.GONE
                        binding.randomButton.isClickable = true
                        Picasso.get().load(R.drawable.placeholder).into(binding.commonImage)
                    }

                })
            binding.progressBar.visibility = View.VISIBLE
            binding.randomButton.isClickable = false

            val text = "Подождите загрузки изображения"
            val duration = Toast.LENGTH_SHORT

            val toast = Toast.makeText(applicationContext, text, duration)
            toast.setGravity(Gravity.CENTER, 0, -400)
            toast.show()
        }

        imageLoader.loadImage()

        binding.randomButton.setOnClickListener {
            imageLoader.loadImage()
        }
    }
}