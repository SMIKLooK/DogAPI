package com.example.dogapi.get_data_from_API

import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.example.dogapi.R
import com.example.dogapi.fragments.RandomDogFragment
import com.squareup.picasso.Picasso
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

class RandomDogCall(private val context: RandomDogFragment, private val callback: (String) -> Unit) {
    fun loadImage() {
        val handler = Handler(Looper.getMainLooper())

        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://api.thedogapi.com/v1/images/search")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                context.requireActivity().runOnUiThread {
                    val progressBar= context.view?.findViewById<ProgressBar>(R.id.progressBar)
                    progressBar?.visibility = View.GONE
                    val commonImage = context.view?.findViewById<ImageView>(R.id.common_image)
                    Picasso.get().load(R.drawable.placeholder).into(commonImage)
                }
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                val responseBody = response.body?.string()

                val imageUrl = JSONArray(responseBody)
                    .getJSONObject(0).getString("url")

                handler.post {
                    callback(imageUrl)
                }
            }
        })
    }
}