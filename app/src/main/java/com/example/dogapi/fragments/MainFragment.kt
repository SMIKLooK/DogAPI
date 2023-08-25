package com.example.dogapi.fragments

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.dogapi.R
import com.example.dogapi.check_connect.hasInternetConnection
import com.example.dogapi.databinding.FragmentMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding  = FragmentMainBinding.inflate(inflater)

        binding.randomDog.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.frame_layout, RandomDogFragment())
                ?.addToBackStack("RandomDogFragment")
                ?.commit()
        }

        binding.dog10.setOnClickListener {
            val scope = CoroutineScope(Dispatchers.Main)
            scope.launch {
                val hasConnection = withContext(Dispatchers.IO) {
                    hasInternetConnection()
                }
                if (hasConnection) {
                    activity?.supportFragmentManager
                        ?.beginTransaction()
                        ?.replace(R.id.frame_layout, Dog10Fragment())
                        ?.addToBackStack("Dog10Fragment")
                        ?.commit()
                } else {
                    val text = "Нет интернета проверьте подключение и перезайдите в приложение"
                    val duration = Toast.LENGTH_LONG

                    val toast = Toast.makeText(context, text, duration)
                    toast.setGravity(Gravity.CENTER, 0, -435)
                    toast.show()
                }
            }
        }
        return binding.root
    }
}