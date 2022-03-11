package com.mindera.dicechallenge.android.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.mindera.dicechallenge.android.R
import com.mindera.dicechallenge.android.databinding.ActivityMainBinding
import com.mindera.dicechallenge.repository.RandomRepository
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel

private val FIELD_ITEMS = listOf("4", "6", "8", "10", "12", "20", "100")

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

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
            viewModel.rollDice(numFaces)
            /*val value = viewModel.rollDice(numFaces)
            binding.tvResult.text = value.toString()*/
        }
        lifecycleScope.launchWhenCreated {
            viewModel.diceValue.collect {
                if (it == ERROR_VALUE) {
                    Snackbar.make(
                        binding.btnRoll,
                        getString(R.string.error_dice_value),
                        Snackbar.LENGTH_LONG
                    ).show()
                } else if (it > INITIAL_VALUE) {
                    binding.tvResult.text = it.toString()
                }
            }
        }
    }
}
