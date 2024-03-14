package com.example.minipro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.minipro.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var databaseHelper: DatabaseManage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btlogin.setOnClickListener {
            val logemail = binding.logemail.text.toString()
            val logpassword = binding.logpassword.text.toString()
            loginDatabase(logemail, logpassword)
        }

        binding.Registerdirect.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
            finish()
        }

        databaseHelper = DatabaseManage(this)

    }

    private fun loginDatabase(email: String, password: String){
        val userExists = databaseHelper.readUser(email, password)
        if (userExists){
            Toast.makeText(this, "login Successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            startActivity(intent)
            finish()
        }else{
            Toast.makeText(this, "login Failed", Toast.LENGTH_SHORT).show()
        }
    }


}