package com.example.dogapi

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.dogapi.call.Callhttp
import com.example.dogapi.databinding.FragmentRandomDogBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

private lateinit var imageLoader: Callhttp


class RandomDogFragment : Fragment() {
    private lateinit var binding: FragmentRandomDogBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRandomDogBinding.inflate(inflater)

        imageLoader = Callhttp() { imageUrl ->
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

        imageLoader.loadImage()

        binding.randomButton.setOnClickListener {
            imageLoader.loadImage()
        }

        return binding.root
    }
}