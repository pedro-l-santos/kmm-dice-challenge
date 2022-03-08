package com.mindera.dicechallenge.android.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.activity.viewModels
import com.mindera.dicechallenge.android.R
import com.mindera.dicechallenge.android.databinding.ActivityMainBinding

private val FIELD_ITEMS = listOf("4", "6", "8", "10", "12", "20", "100")

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupTextField()
        setupRollButton()
    }

    private fun setupTextField() {
        val adapter = ArrayAdapter(applicationContext, R.layout.item_text_field, FIELD_ITEMS)
        val itemsList = binding.textFieldNumFaces.editText as? AutoCompleteTextView
        itemsList?.setAdapter(adapter)
        itemsList?.setText(FIELD_ITEMS[0], false)
        itemsList?.setDropDownBackgroundResource(R.color.grey)
    }

    private fun setupRollButton() {
        binding.btnRoll.setOnClickListener {
            val numFaces = binding.textFieldNumFaces.editText?.text.toString().toInt()
            val value = viewModel.rollDice(numFaces)
            binding.tvResult.text = value.toString()
        }
    }
}
