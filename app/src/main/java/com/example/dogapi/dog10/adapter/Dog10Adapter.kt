package com.example.dogapi.dog10.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogapi.R
import com.example.dogapi.dog10.model.Dog10
import com.squareup.picasso.Picasso

class Dog10Adapter(private val dataset: List<Dog10>): RecyclerView.Adapter<Dog10Adapter.HolderDog10>() {


    class HolderDog10(view: View): RecyclerView.ViewHolder(view){
        fun x (dog10: Dog10){
            val imageView: ImageView = itemView.findViewById(R.id.image10)
            Picasso.get().load(dog10.dogUrl)
                .placeholder(R.drawable.loading)
                .error(R.drawable.placeholder)
                .into(imageView)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderDog10 {
         val adapterLayout = LayoutInflater.from(parent.context)
             .inflate(R.layout.image_item, parent, false)

        return HolderDog10(adapterLayout)
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: HolderDog10, position: Int) {
       holder.x(dataset[position])
    }
}