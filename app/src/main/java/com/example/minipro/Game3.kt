package com.example.minipro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Game3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game3)

        val btcartg3: Button = findViewById(R.id.btcartg3)

        val btaddcartg3: Button = findViewById(R.id.btaddcartg3)

        val btuserg3: Button = findViewById(R.id.btuserg3)
        val btmaing3: Button = findViewById(R.id.btmaing3)
        val bthistoryg3: Button = findViewById(R.id.bthistoryg3)
        val btlogoutg3: Button = findViewById(R.id.btlogoutg3)

        val email = intent.getStringExtra("email") ?: ""
        val password = intent.getStringExtra("password") ?: ""

        val gname = intent.getStringExtra("gname") ?: ""
        val gprice = intent.getStringExtra("gprice") ?: ""

        //ปุ่มไปยังตระกร้าสินค้า
        btcartg3.setOnClickListener{
            val intent = Intent(this,  shopping::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }

        btaddcartg3.setOnClickListener{
            val intent = Intent(this,  shopping::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", "Hogwarts legacy")
            intent.putExtra("gprice", "2450")
            startActivity(intent)
        }

        //ปุ่มไปยังหน้าต่างๆ
        btuserg3.setOnClickListener{
            val intent = Intent(this,  EditProfile::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }
        btmaing3.setOnClickListener{
            val intent = Intent(this,  MainActivity::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }
        bthistoryg3.setOnClickListener{
            val intent = Intent(this,  Order_His::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }
        btlogoutg3.setOnClickListener{
            val intent = Intent(this,  Login::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }
    }
}