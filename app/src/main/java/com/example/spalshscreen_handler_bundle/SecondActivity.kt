 package com.example.spalshscreen_handler_bundle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.spalshscreen_handler_bundle.databinding.ActivitySecondBinding

 class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent
        val name = i.extras?.getString("name")
        binding.textName.setText(name)

        binding.button.setOnClickListener{
            i.putExtra("name", binding.textName.text.toString())
            setResult(1,i)
            finish()
        }

        binding.button2.setOnClickListener{
            setResult(2,i)
            finish()
        }
    }
}