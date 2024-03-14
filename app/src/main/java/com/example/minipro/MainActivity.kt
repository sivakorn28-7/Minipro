package com.example.minipro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btcartmain: Button = findViewById(R.id.btcartmain)

        val btgame1: ImageButton = findViewById(R.id.btgame1)
        val btgame2: ImageButton = findViewById(R.id.btgame2)
        val btgame3: ImageButton = findViewById(R.id.btgame3)
        val btgame4: ImageButton = findViewById(R.id.btgame4)
        val btgame5: ImageButton = findViewById(R.id.btgame5)
        val btgame6: ImageButton = findViewById(R.id.btgame6)

        val btusermain: Button = findViewById(R.id.btusermain)
        val btmainmain: Button = findViewById(R.id.btmainmain)
        val bthistorymain: Button = findViewById(R.id.bthistorymain)
        val btlogoutmain: Button = findViewById(R.id.btlogoutmain)

        val email = intent.getStringExtra("email") ?: ""
        val password = intent.getStringExtra("password") ?: ""

        val gname = intent.getStringExtra("gname") ?: ""
        val gprice = intent.getStringExtra("gprice") ?: ""

        //ปุ่มไปยังตระกร้าสินค้า
        btcartmain.setOnClickListener{
            val intent = Intent(this,  shopping::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }

        //ปุ่มไปยังเกมต่างๆ
        btgame1.setOnClickListener{
            val intent = Intent(this,  Game1::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }
        btgame2.setOnClickListener{
            val intent = Intent(this,  Game2::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }
        btgame3.setOnClickListener{
            val intent = Intent(this,  Game3::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }
        btgame4.setOnClickListener{
            val intent = Intent(this,  Game4::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }
        btgame5.setOnClickListener{
            val intent = Intent(this,  Game5::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }
        btgame6.setOnClickListener{
            val intent = Intent(this,  Game6::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }

        //ปุ่มไปยังหน้าต่างๆ
        btusermain.setOnClickListener{
            val intent = Intent(this,  EditProfile::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }
//        btmainmain.setOnClickListener{
//            val intent = Intent(this,  MainActivity::class.java)
//            startActivity(intent)
//        }
        bthistorymain.setOnClickListener{
            val intent = Intent(this,  Order_His::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gname", gname)
            intent.putExtra("gprice", gprice)
            startActivity(intent)
        }
        btlogoutmain.setOnClickListener{
            val intent = Intent(this,  Login::class.java)
            startActivity(intent)
        }
    }
}