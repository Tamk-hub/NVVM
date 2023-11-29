package com.example.nvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.nvvm.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

       val viewModel =ViewModelProvider(this).get(GuessViewModel::class.java)
        viewModel.message.observe(this,Observer{binding.message.setText(it)})
        viewModel.times.observe(this, Observer { binding.counter.setText(it.toString()) })

        binding.button.setOnClickListener {
            viewModel.guess(binding.number.text.toString().toInt())

        }

    }
}