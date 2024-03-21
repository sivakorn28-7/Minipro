package com.example.minipro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.minipro.databinding.ActivityEditProfileBinding
import com.example.minipro.databinding.ActivitySubmitBinding

class Submit : AppCompatActivity() {
    private lateinit var binding: ActivitySubmitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubmitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = intent.getStringExtra("email") ?: ""
        val password = intent.getStringExtra("password") ?: ""

        val gname = intent.getStringExtra("gname") ?: ""
        val gprice = intent.getStringExtra("gprice") ?: ""

        val btnextsub: Button = findViewById(R.id.btnextsub)

        val databaseHelper = DatabaseManage(this)
        val userInfoList = databaseHelper.getUserInfo(email, password)

        if (userInfoList.isNotEmpty()) {
            val userInfo = userInfoList[0]
            binding.name.setText(userInfo.name)
            binding.surname.setText(userInfo.surname)
            binding.phone.setText(userInfo.phoneNumber)
            binding.email.setText(userInfo.email)
        }

        btnextsub.setOnClickListener {
            val name = binding.name.text.toString().trim()
            val surname = binding.surname.text.toString().trim()
            val phone = binding.phone.text.toString().trim()
            val email = binding.email.text.toString().trim() // เพิ่มการดึงข้อมูลอีเมล

            if (name.isEmpty() || surname.isEmpty() || phone.isEmpty() || email.isEmpty()) {
                // แจ้งเตือนให้กรอกข้อมูลให้ครบ
                Toast.makeText(this@Submit, "กรุณากรอกข้อมูลให้ครบถ้วน", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this@Submit, Address::class.java)
                intent.putExtra("email", email)
                intent.putExtra("password", password)
                intent.putExtra("gname", gname)
                intent.putExtra("gprice", gprice)
                startActivity(intent)
            }
        }
    }
}