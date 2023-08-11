package com.example.dogapi.call

import android.os.Handler
import android.os.Looper
import com.example.dogapi.formatting_to_json.CallToJSON
import okhttp3.*
import java.io.IOException


class Callhttp(private val callback: (String) -> Unit) {

    private val handler = Handler(Looper.getMainLooper())

    fun loadImage() {
        val handler = Handler(Looper.getMainLooper())

        val client = OkHttpClient()

        val request = Request.Builder()
            .url("https://api.thedogapi.com/v1/images/search")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                val responseBody = response.body?.string()
                val imageUrl = CallToJSON().extractImageUrl(responseBody!!)

                handler.post {
                    // Выполняется в главном потоке
                    callback(imageUrl)
                }
            }
        })
    }
}