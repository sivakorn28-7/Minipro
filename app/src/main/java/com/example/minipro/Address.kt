package com.example.minipro

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.minipro.databinding.ActivityAddressBinding

class Address : AppCompatActivity() {
    private lateinit var binding: ActivityAddressBinding
    private lateinit var databaseHelper: DatabaseManage

    private val PICK_IMAGE_REQUEST = 1
    private lateinit var selectedImageUri: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val priceshow: TextView = findViewById(R.id.priceshow)

        val email = intent.getStringExtra("email") ?: ""
        val password = intent.getStringExtra("password") ?: ""

        val gname = intent.getStringExtra("gname") ?: ""
        val gprice = intent.getStringExtra("gprice") ?: ""

        priceshow.text = gprice

        databaseHelper = DatabaseManage(this)

        binding.submitaddress.setOnClickListener {
            val userInfoList = databaseHelper.getUserInfo(email, password)
            val userid = userInfoList.firstOrNull()?.userid ?: 0 // สมมติว่ามีฟิลด์ชื่อ userid

            val address = binding.shopaddress.text.toString().trim()

            if (address.isNotEmpty()) {
                // เช็คว่าผู้ใช้เลือกรูปภาพหรือไม่
                if (::selectedImageUri.isInitialized) {
                    // เก็บข้อมูลในตาราง gamedata
                    val success = databaseHelper.insertGame(userid, gname, gprice.toDouble())
                    if (success != -1L) {
                        // ข้อมูลถูกเก็บเรียบร้อย
                        val intent = Intent(this, Order_His::class.java)
                        intent.putExtra("email", email)
                        intent.putExtra("password", password)
                        startActivity(intent)
                    } else {
                        // เกิดข้อผิดพลาดในการเก็บข้อมูล
                        // แสดงข้อความผลลัพธ์เกี่ยวกับการเก็บข้อมูลไม่สำเร็จ
                    }
                } else {
                    // ถ้าไม่ได้เลือกรูปภาพ ให้แจ้งให้ผู้ใช้เลือกรูปภาพ
                    Toast.makeText(this, "โปรดเลือกรูปภาพ", Toast.LENGTH_SHORT).show()
                }
            } else {
                // ถ้าที่อยู่ไม่ถูกต้อง แสดงข้อความให้ผู้ใช้กรอกข้อมูลใหม่
                binding.shopaddress.error = "โปรดกรอกที่อยู่"
                binding.shopaddress.requestFocus()
            }
        }

        binding.filebt.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, PICK_IMAGE_REQUEST)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.data != null) {
            selectedImageUri = data.data!!

            // นำ selectedImageUri ไปแสดงบน ImageView หรือทำอย่างอื่นตามต้องการ
            val imageView: ImageView = findViewById(R.id.fileshow)
            imageView.setImageURI(selectedImageUri)
        }
    }
}