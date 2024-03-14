package com.example.minipro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.minipro.databinding.ActivityEditProfileBinding

class EditProfile : AppCompatActivity() {
    private lateinit var binding: ActivityEditProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btcartuser: Button = findViewById(R.id.btcartuser)

        val btuseruser: Button = findViewById(R.id.btuseruser)
        val btmainuser: Button = findViewById(R.id.btmainuser)
        val bthistoryuser: Button = findViewById(R.id.bthistoryuser)
        val btlogoutuser: Button = findViewById(R.id.btlogoutuser)


        val email = intent.getStringExtra("email") ?: ""
        val password = intent.getStringExtra("password") ?: ""

        val gname = intent.getStringExtra("gname") ?: ""
        val gprice = intent.getStringExtra("gprice") ?: ""

        val databaseHelper = DatabaseManage(this)
        val userInfoList = databaseHelper.getUserInfo(email, password)

        if (userInfoList.isNotEmpty()) {
            val userInfo = userInfoList[0]
            binding.name.setText(userInfo.name)
            binding.surname.setText(userInfo.surname)
            binding.email.setText(userInfo.email)
            binding.phone.setText(userInfo.phoneNumber)
            binding.password.setText(password) // แสดงรหัสผ่านใน EditText password
        }

        binding.btedituser.setOnClickListener {

            val newEmail = binding.email.text.toString()
            val newName = binding.name.text.toString()
            val newSurname = binding.surname.text.toString()
            val newPassword = binding.password.text.toString()
            val newPhone = binding.phone.text.toString()

            val updated = databaseHelper.updateUser(email, password, newEmail, newName, newSurname, newPhone, newPassword)
            if (updated) {
                Toast.makeText(this, "User information updated successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Failed to update user information", Toast.LENGTH_SHORT).show()
            }

        }
            //ปุ่มไปยังตระกร้าสินค้า
            btcartuser.setOnClickListener {
                val intent = Intent(this, shopping::class.java)
                intent.putExtra("email", email)
                intent.putExtra("password", password)
                intent.putExtra("gname", gname)
                intent.putExtra("gprice", gprice)
                startActivity(intent)
            }


            //ปุ่มไปยังหน้าต่างๆ
//        btuseruser.setOnClickListener{
//            val intent = Intent(this,  EditProfile::class.java)
//            startActivity(intent)
//        }
            btmainuser.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("email", email)
                intent.putExtra("password", password)
                intent.putExtra("gname", gname)
                intent.putExtra("gprice", gprice)
                startActivity(intent)
            }
            bthistoryuser.setOnClickListener {
                val intent = Intent(this, Order_His::class.java)
                intent.putExtra("email", email)
                intent.putExtra("password", password)
                intent.putExtra("gname", gname)
                intent.putExtra("gprice", gprice)
                startActivity(intent)
            }
            btlogoutuser.setOnClickListener {
                val intent = Intent(this, Login::class.java)
                startActivity(intent)
            }
        }
    }
