package com.example.dogapi.get_data_from_API

import kotlinx.coroutines.runBlocking
import okhttp3.*
import org.json.JSONArray
import java.io.IOException


class Dog10Call() {
    suspend fun loadImage(x: Int): String = runBlocking{
        val client = OkHttpClient()

        val request = Request.Builder()
            .url("https://api.thedogapi.com/v1/images/search?limit=10")
            .build()


        val response = client.newCall(request).execute()

        if (!response.isSuccessful) {
            throw IOException("Unexpected code $response")
        }
        val responseBody = response.body?.string()

        val dogJson = JSONArray(responseBody).getJSONObject(x)

        val dogUlr  = dogJson.getString("url")

        dogUlr
    }
}