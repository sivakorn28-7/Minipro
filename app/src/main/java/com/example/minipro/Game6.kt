package com.example.minipro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Game6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game6)

        val btcartg6: Button = findViewById(R.id.btcartg6)

        val btaddcartg6: Button = findViewById(R.id.btaddcartg6)

        val btuserg6: Button = findViewById(R.id.btuserg6)
        val btmaing6: Button = findViewById(R.id.btmaing6)
        val bthistoryg6: Button = findViewById(R.id.bthistoryg6)
        val btlogoutg6: Button = findViewById(R.id.btlogoutg6)

        val email = intent.getStringExtra("email") ?: ""
        val password = intent.getStringExtra("password") ?: ""

        val gname = intent.getStringExtra("gname") ?: ""
        val gprice = intent.getStringExtra("gprice") ?: ""

        //ปุ่มไปยังตระกร้าสินค้า
        btcartg6.setOnClickListener{
            val intent = Intent(this,  shopping::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }

        btaddcartg6.setOnClickListener{
            val intent = Intent(this,  shopping::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", "Spider man 2")
            intent.putExtra("gprice", "2290")
            startActivity(intent)
        }

        //ปุ่มไปยังหน้าต่างๆ
        btuserg6.setOnClickListener{
            val intent = Intent(this,  EditProfile::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }
        btmaing6.setOnClickListener{
            val intent = Intent(this,  MainActivity::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }
        bthistoryg6.setOnClickListener{
            val intent = Intent(this,  Order_His::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }
        btlogoutg6.setOnClickListener{
            val intent = Intent(this,  Login::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }
    }
}