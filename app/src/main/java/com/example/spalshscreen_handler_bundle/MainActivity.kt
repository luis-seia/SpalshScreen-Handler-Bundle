package com.example.spalshscreen_handler_bundle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.example.spalshscreen_handler_bundle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var result: ActivityResultLauncher<Intent>
    private var name =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btn.setOnClickListener{
            result.launch(Intent(this, SecondActivity::class.java).putExtra("name",name))
        }
        result = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.data !=null && it.resultCode ==1){
                name = it.data?.getStringExtra("name").toString()
                binding.textView.text = "ola $name"
            }else if(it.data !=null && it.resultCode ==2){
                Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "erro", Toast.LENGTH_SHORT).show()
            }
        }

    }
}