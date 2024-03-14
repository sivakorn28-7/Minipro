package com.example.minipro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Game5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game5)

        val btcartg5: Button = findViewById(R.id.btcartg5)

        val btaddcartg5: Button = findViewById(R.id.btaddcartg5)

        val btuserg5: Button = findViewById(R.id.btuserg5)
        val btmaing5: Button = findViewById(R.id.btmaing5)
        val bthistoryg5: Button = findViewById(R.id.bthistoryg5)
        val btlogoutg5: Button = findViewById(R.id.btlogoutg5)

        val email = intent.getStringExtra("email") ?: ""
        val password = intent.getStringExtra("password") ?: ""

        val gname = intent.getStringExtra("gname") ?: ""
        val gprice = intent.getStringExtra("gprice") ?: ""

        //ปุ่มไปยังตระกร้าสินค้า
        btcartg5.setOnClickListener{
            val intent = Intent(this,  shopping::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }

        btaddcartg5.setOnClickListener{
            val intent = Intent(this,  shopping::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", "Gran turismo 7")
            intent.putExtra("gprice", "2290")
            startActivity(intent)
        }

        //ปุ่มไปยังหน้าต่างๆ
        btuserg5.setOnClickListener{
            val intent = Intent(this,  EditProfile::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }
        btmaing5.setOnClickListener{
            val intent = Intent(this,  MainActivity::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }
        bthistoryg5.setOnClickListener{
            val intent = Intent(this,  Order_His::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }
        btlogoutg5.setOnClickListener{
            val intent = Intent(this,  Login::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }
    }
}