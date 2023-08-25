package com.example.dogapi.dog10

import com.example.dogapi.dog10.model.Dog10
import com.example.dogapi.get_data_from_API.Dog10Call


class Dog10Datasource() {
    suspend fun loadDog10(): List<Dog10> {
        return listOf<Dog10>(
            Dog10(Dog10Call().loadImage(0)),
            Dog10(Dog10Call().loadImage(1)),
            Dog10(Dog10Call().loadImage(2)),
            Dog10(Dog10Call().loadImage(3)),
            Dog10(Dog10Call().loadImage(4)),
            Dog10(Dog10Call().loadImage(5)),
            Dog10(Dog10Call().loadImage(6)),
            Dog10(Dog10Call().loadImage(7)),
            Dog10(Dog10Call().loadImage(8)),
            Dog10(Dog10Call().loadImage(9))

        )
    }
}