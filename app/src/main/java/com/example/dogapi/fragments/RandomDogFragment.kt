package com.example.dogapi.fragments

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.dogapi.R
import com.example.dogapi.databinding.FragmentRandomDogBinding
import com.example.dogapi.get_data_from_API.RandomDogCall
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

private lateinit var imageLoader: RandomDogCall

class RandomDogFragment : Fragment() {
    private lateinit var binding: FragmentRandomDogBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRandomDogBinding.inflate(inflater)

        imageLoader = RandomDogCall(this) { imageUrl ->
            Picasso.get().load(imageUrl)
                .into(binding.commonImage, object : Callback {
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

            val toast = Toast.makeText(context, text, duration)
            toast.setGravity(Gravity.CENTER, 0, -435)
            toast.show()
        }

        val filename = "myfile"
        val fileContents = "Hello world!"
        context?.openFileOutput(filename, Context.MODE_PRIVATE).use {
            it?.write(fileContents.toByteArray())
        }
        imageLoader.loadImage()

        binding.randomButton.setOnClickListener {
            imageLoader.loadImage()
        }

        return binding.root
    }
}