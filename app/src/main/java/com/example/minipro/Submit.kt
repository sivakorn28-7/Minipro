package com.example.minipro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Submit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)

        val email = intent.getStringExtra("email") ?: ""
        val password = intent.getStringExtra("password") ?: ""
    }
}