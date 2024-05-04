package com.muhammedjasir.bmicalculator.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.muhammedjasir.bmicalculator.R
import com.muhammedjasir.bmicalculator.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle: Bundle? = intent.extras
        val weight = bundle?.getFloat("weight")
        val height = bundle?.getFloat("height")
        val age = bundle?.getInt("age")
        val gender = bundle?.getChar("gender")

        calculateBMI(weight, height, age,gender)

        binding.checkAnotherBtn.setOnClickListener {
            this.finish()
        }

        binding.headLayout.setOnClickListener {
            this.finish()
        }

    }

    private fun calculateBMI(weight: Float?, height: Float?, age: Int?, gender: Char?) {
        if (weight != null && height != null && age != null && gender != null) {
            val bmi = ((weight / (height * height)) * 10000)
            val bmiResult = String.format("%.2f", bmi)
            val bmiCategory = when {
                bmi < 18.5 -> "Under weight"
                bmi < 25 -> "Normal weight"
                bmi < 30 -> "Over weight"
                else -> "Obese"
            }
            Log.d("Result", bmiResult)
            Log.d("Status", bmiCategory)
            binding.resultStatus.text = bmiCategory
            binding.resultValue.text = bmiResult
        } else {
            binding.resultStatus.text = resources.getText(R.string.invalid_input)
            binding.resultValue.text = "--"
        }
    }
}