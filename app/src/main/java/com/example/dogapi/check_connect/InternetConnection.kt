package com.example.dogapi.check_connect

import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

fun hasInternetConnection(): Boolean {
    val client = OkHttpClient()
    val request = Request.Builder().url("https://www.google.com").build()

    try {
        val response = client.newCall(request).execute()
        return response.isSuccessful
    } catch (e: IOException) {
        e.printStackTrace()
    }
    return false
}