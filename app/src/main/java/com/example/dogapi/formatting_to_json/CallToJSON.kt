package com.example.dogapi.formatting_to_json


import org.json.JSONArray

class CallToJSON {
    fun extractImageUrl(responseBody: String): String {
        val jsonArray = JSONArray(responseBody)
        val imageUrl = jsonArray.getJSONObject(0).getString("url")
        return imageUrl
    }
}