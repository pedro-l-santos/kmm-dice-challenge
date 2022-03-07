package com.mindera.dicechallenge.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mindera.dicechallenge.Greeting
import android.widget.TextView
import com.mindera.dicechallenge.DiceManager
import com.mindera.dicechallenge.android.databinding.ActivityMainBinding
import java.lang.NumberFormatException

fun rollDice(numFaces: Int): Int = DiceManager().rollDice(numFaces)

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupRollButton()
    }

    private fun setupRollButton() {
        binding.btnRoll.setOnClickListener {
            val numFaces: Int
            try {
                numFaces = binding.textFieldNumFaces.editText?.text.toString().toInt()
            } catch (e: NumberFormatException) {
                return@setOnClickListener
            }
            if (numFaces < 1) { return@setOnClickListener }
            val value = rollDice(numFaces)
            binding.tvResult.text = value.toString()
        }
    }
}
