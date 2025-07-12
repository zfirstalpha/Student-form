package com.example.form_internship

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {lateinit var etName: EditText
    lateinit var etAge: EditText
    lateinit var radioGroup: RadioGroup
    lateinit var spinner: Spinner
    lateinit var btnSubmit: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        etName = findViewById(R.id.etname)
        etAge = findViewById(R.id.etAge)
        radioGroup = findViewById(R.id.radioGroupGender)
        spinner = findViewById(R.id.spinner)
        btnSubmit = findViewById(R.id.btnSubmit)

        // Set up spinner
        val spinnerArray = resources.getStringArray(R.array.department)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArray)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter


// saving data
        if (savedInstanceState != null) {
            //name
            val savedName = savedInstanceState.getString("savedName")
            if (savedName != null) {
                etName.setText(savedName)
            }

            // resto4e age
            val savedAge = savedInstanceState.getString("savedAge")
            if (savedAge != null) {
                etAge.setText(savedAge)
            }

            // restore gender
            val savedGenderId = savedInstanceState.getInt("savedGenderId", -1)
            if (savedGenderId != -1) {
                radioGroup.check(savedGenderId)
            }

            // restore department
            val savedSpinnerPosition = savedInstanceState.getInt("savedSpinnerPosition", 0)
            spinner.setSelection(savedSpinnerPosition)
        }

        btnSubmit.setOnClickListener {
            val name = etName.text.toString()
            val age = etAge.text.toString()
            val genderId = radioGroup.checkedRadioButtonId
            val gender = if (genderId != -1) {
                findViewById<RadioButton>(genderId).text.toString()
            } else {
                "Not selected"
            }
            val department = spinner.selectedItem.toString()

            // Pass data to second activity
            val intent = Intent(this, DisplayActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("age", age)
            intent.putExtra("gender", gender)
            intent.putExtra("department", department)
            startActivity(intent)
        }}

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        // Save current form data
        outState.putString("savedName", etName.text.toString())
        outState.putString("savedAge", etAge.text.toString())
        outState.putInt("savedGenderId", radioGroup.checkedRadioButtonId)
        outState.putInt("savedSpinnerPosition", spinner.selectedItemPosition)
    }

}