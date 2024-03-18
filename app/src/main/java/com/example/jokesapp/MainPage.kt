package com.example.jokesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jokesapp.databinding.ActivityMainPageBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.net.URL

class MainPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.generateBt.setOnClickListener {

            GlobalScope.launch(Dispatchers.IO) {
                val conn = URL("https://candaan-api.vercel.app/api/text/random").openStream().bufferedReader().readText()
                var que = JSONObject(conn)
                runOnUiThread {

                    binding.questionTv.text = que.getString("data")
//                    binding.showBt.setOnClickListener {
//                        binding.questionTv.text = q[1]
//
//                    }
                }
            }
        }

    }
}