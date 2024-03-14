package com.example.minipro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Order_His : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_his)

        val btcarthistory: Button = findViewById(R.id.btcarthistory)

        val btuserhistory: Button = findViewById(R.id.btuserhistory)
        val btmainhistory: Button = findViewById(R.id.btmainhistory)
        val bthistoryhistory: Button = findViewById(R.id.bthistoryhistory)
        val btlogouthistory: Button = findViewById(R.id.btlogouthistory)

        val email = intent.getStringExtra("email") ?: ""
        val password = intent.getStringExtra("password") ?: ""

        val gname = intent.getStringExtra("gname") ?: ""
        val gprice = intent.getStringExtra("gprice") ?: ""

        //ปุ่มไปยังตระกร้าสินค้า
        btcarthistory.setOnClickListener{
            val intent = Intent(this,  shopping::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }









        //ปุ่มไปยังหน้าต่างๆ
        btuserhistory.setOnClickListener{
            val intent = Intent(this,  EditProfile::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }
        btmainhistory.setOnClickListener{
            val intent = Intent(this,  MainActivity::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }
//        bthistoryhistory.setOnClickListener{
//            val intent = Intent(this,  Order_His::class.java)
//            startActivity(intent)
//        }
        btlogouthistory.setOnClickListener{
            val intent = Intent(this,  Login::class.java)
            startActivity(intent)
        }
    }
}