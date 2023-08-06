package com.example.dogapi.formatting_to_json

import android.os.Handler
import android.os.Looper
import com.example.dogapi.call.Callhttp
import org.json.JSONArray

class CallToJSON{
    fun extractImageUrl(responseBody: String): String {
        val jsonArray = JSONArray(responseBody)
        val imageUrl = jsonArray.getJSONObject(0).getString("url")
        return imageUrl
    }
}