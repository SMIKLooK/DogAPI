package com.example.dogapi.cache

import java.io.File

fun randomDogCache(): File {
    return File("DogApi", "filename")
}