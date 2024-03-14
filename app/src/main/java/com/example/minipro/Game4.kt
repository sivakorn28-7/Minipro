package com.example.minipro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Game4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game4)

        val btcartg4: Button = findViewById(R.id.btcartg4)

        val btaddcartg4: Button = findViewById(R.id.btaddcartg4)

        val btuserg4: Button = findViewById(R.id.btuserg4)
        val btmaing4: Button = findViewById(R.id.btmaing4)
        val bthistoryg4: Button = findViewById(R.id.bthistoryg4)
        val btlogoutg4: Button = findViewById(R.id.btlogoutg4)

        val email = intent.getStringExtra("email") ?: ""
        val password = intent.getStringExtra("password") ?: ""

        val gname = intent.getStringExtra("gname") ?: ""
        val gprice = intent.getStringExtra("gprice") ?: ""

        //ปุ่มไปยังตระกร้าสินค้า
        btcartg4.setOnClickListener{
            val intent = Intent(this,  shopping::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }

        btaddcartg4.setOnClickListener{
            val intent = Intent(this,  shopping::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", "The last of us part 1")
            intent.putExtra("gprice", "2290")
            startActivity(intent)
        }

        //ปุ่มไปยังหน้าต่างๆ
        btuserg4.setOnClickListener{
            val intent = Intent(this,  EditProfile::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }
        btmaing4.setOnClickListener{
            val intent = Intent(this,  MainActivity::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }
        bthistoryg4.setOnClickListener{
            val intent = Intent(this,  Order_His::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }
        btlogoutg4.setOnClickListener{
            val intent = Intent(this,  Login::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }
    }
}