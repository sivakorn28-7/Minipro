package com.example.minipro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Game1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game1)

        val btcartg1: Button = findViewById(R.id.btcartg1)

        val btaddcartg1: Button = findViewById(R.id.btaddcartg1)

        val btuserg1: Button = findViewById(R.id.btuserg1)
        val btmaing1: Button = findViewById(R.id.btmaing1)
        val bthistoryg1: Button = findViewById(R.id.bthistoryg1)
        val btlogoutg1: Button = findViewById(R.id.btlogoutg1)

        val email = intent.getStringExtra("email") ?: ""
        val password = intent.getStringExtra("password") ?: ""

        val gname = intent.getStringExtra("gname") ?: ""
        val gprice = intent.getStringExtra("gprice") ?: ""

        //ปุ่มไปยังตระกร้าสินค้า
        btcartg1.setOnClickListener{
            val intent = Intent(this,  shopping::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }

        btaddcartg1.setOnClickListener{
            val intent = Intent(this,  shopping::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", "God of war" )
            intent.putExtra("gprice",  "1305")
            startActivity(intent)
        }

        //ปุ่มไปยังหน้าต่างๆ
        btuserg1.setOnClickListener{
            val intent = Intent(this,  EditProfile::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }
        btmaing1.setOnClickListener{
            val intent = Intent(this,  MainActivity::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }
        bthistoryg1.setOnClickListener{
            val intent = Intent(this,  Order_His::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }
        btlogoutg1.setOnClickListener{
            val intent = Intent(this,  Login::class.java)
            startActivity(intent)
        }
    }
}