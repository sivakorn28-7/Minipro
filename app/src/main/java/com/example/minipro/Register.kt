package com.example.minipro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.minipro.databinding.ActivityRegisterBinding

class Register : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var databaseHelper: DatabaseManage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        databaseHelper = DatabaseManage(this)

        binding.btregister.setOnClickListener {
            val reemail = binding.reemail.text.toString()
            val repassword = binding.repassword.text.toString()
            val rename = binding.rename.text.toString()
            val resurname = binding.resurname.text.toString()
            val rephone = binding.rephone.text.toString()
            signupDatabase(reemail, repassword,rename,resurname,rephone)
        }

        binding.Logindirect.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun signupDatabase(email: String, password: String, name: String, surname: String, phoneNumber: String){
        val insertedRowId = databaseHelper.insertUser(email , password , name, surname, phoneNumber)
        if (insertedRowId != -1L){
            Toast.makeText(this, "Signup Successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }else{
            Toast.makeText(this, "Signup Failed", Toast.LENGTH_SHORT).show()
        }
    }
}