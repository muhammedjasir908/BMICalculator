package com.muhammedjasir.bmicalculator.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.muhammedjasir.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var gender = 'M'
    private var height = 1
    private var weight = 50
    private var age = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.maleCard.setCardBackgroundColor(Color.parseColor("#03AED2"))
        binding.ageText.text = age.toString()
        binding.weightText.text = weight.toString()
        binding.heightText.text = height.toString()

        binding.maleCard.setOnClickListener {
            gender = 'M'
            binding.maleCard.setCardBackgroundColor(Color.parseColor("#03AED2"))
            binding.femaleCard.setCardBackgroundColor(Color.WHITE)
        }

        binding.femaleCard.setOnClickListener {
            gender = 'F'
            binding.femaleCard.setCardBackgroundColor(Color.parseColor("#03AED2"))
            binding.maleCard.setCardBackgroundColor(Color.WHITE)
        }

        binding.ageSlider.addOnChangeListener { slider, fl, b ->
            Log.d("Slider",fl.toString())
            binding.ageText.text = Math.round(fl).toString()
        }

        binding.weightIncrementBtn.setOnClickListener {
            var w = binding.weightText.text.toString().toFloatOrNull()
            if(w != null){
                w += 1
                binding.weightText.text = w.toString()
            }else{
                Toast.makeText(this,"Invalid weight!",Toast.LENGTH_LONG).show()
            }
        }

        binding.weightDecrementBtn.setOnClickListener {
            var w = binding.weightText.text.toString().toFloatOrNull()
            if(w != null && w > 0){
                w -= 1
                binding.weightText.text = w.toString()
            }else{
                Toast.makeText(this,"Invalid weight!",Toast.LENGTH_LONG).show()
            }
        }

        binding.heightIncrementBtn.setOnClickListener {
            var h = binding.heightText.text.toString().toFloatOrNull()
            if(h != null){
                h += 1
                binding.heightText.text = h.toString()
            }else{
                Toast.makeText(this,"Invalid weight!",Toast.LENGTH_LONG).show()
            }
        }

        binding.heightDecrementBtn.setOnClickListener {
            var h = binding.heightText.text.toString().toFloatOrNull()
            if(h != null && h > 0){
                h -= 1
                binding.heightText.text = h.toString()
            }else{
                Toast.makeText(this,"Invalid height!",Toast.LENGTH_LONG).show()
            }
        }

        binding.calculateBtn.setOnClickListener {

            val weightValue = binding.weightText.text.toString().toFloatOrNull()
            val heightValue = binding.heightText.text.toString().toFloatOrNull()
            val ageValue = binding.ageText.text.toString().toIntOrNull()

            if(weightValue != null && heightValue != null && ageValue != null) {

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("weight", weightValue)
                intent.putExtra("height", heightValue)
                intent.putExtra("age", ageValue)
                intent.putExtra("gender",gender)
                startActivity(intent)
            }else{
                Toast.makeText(this,"Invalid input!",Toast.LENGTH_LONG).show()
            }
        }
    }


}