package com.example.form_internship

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DisplayActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_display)

        val name = intent.getStringExtra("name")
        val age = intent.getStringExtra("age")
        val gender = intent.getStringExtra("gender")
        val department = intent.getStringExtra("department")

        findViewById<TextView>(R.id.textView11).text = name ?: "null"
        findViewById<TextView>(R.id.textView17).text = age ?: "null"
        findViewById<TextView>(R.id.textView5).text = gender ?: "null"
        findViewById<TextView>(R.id.textView18).text = department ?: "null"
    }
}