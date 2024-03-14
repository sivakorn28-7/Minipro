package com.example.minipro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class shopping : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val gamename: TextView = findViewById(R.id.gamename)
        val gameprice: TextView = findViewById(R.id.gameprice)
        val finalprice: TextView = findViewById(R.id.finalprice)

        val btcartshop: Button = findViewById(R.id.btcartshop)
        val btnextshop: Button = findViewById(R.id.btnextshop)
        val btusershop: Button = findViewById(R.id.btusershop)
        val btmainshop: Button = findViewById(R.id.btmainshop)
        val bthistoryshop: Button = findViewById(R.id.bthistoryshop)
        val btlogoutshop: Button = findViewById(R.id.btlogoutshop)


        val email = intent.getStringExtra("email") ?: ""
        val password = intent.getStringExtra("password") ?: ""

        val gname = intent.getStringExtra("gname") ?: ""
        val gprice = intent.getStringExtra("gprice") ?: ""

        gamename.text = gname
        gameprice.text = gprice
        finalprice.text = gprice



//        btcartshop.setOnClickListener{
//            val intent = Intent(this,  shopping::class.java)
//            intent.putExtra("email", email)
//            intent.putExtra("password", password)
//            startActivity(intent)
//        }


        // ปุ่มไปยังหน้าต่างๆ
        btusershop.setOnClickListener {
            val intent = Intent(this, EditProfile::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }
        btmainshop.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }
        bthistoryshop.setOnClickListener {
            val intent = Intent(this, Order_His::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }
        btlogoutshop.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        // ปุ่มต่อไป
        btnextshop.setOnClickListener {
            val intent = Intent(this, Submit::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }

    }
}