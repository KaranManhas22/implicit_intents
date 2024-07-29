package com.karan.implicit_intents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var btnsms: Button? = null
    var btnemail: Button? = null
    var btncall: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        btnsms = findViewById(R.id.btnsms)
        btnemail = findViewById(R.id.btnemail)
        btncall = findViewById(R.id.btncall)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnsms?.setOnClickListener {
            val btnsms = Intent(Intent.ACTION_SENDTO)
            btnsms.data = Uri.parse("smsto:xxxxxxxxxx")
            btnsms.putExtra("sms_body", "HELLO ")
            startActivity(btnsms)
        }
        btnemail?.setOnClickListener {
            val btnemail = Intent(Intent.ACTION_SENDTO)
            btnemail.setData(Uri.parse("mailto:"))
            btnemail.putExtra(Intent.EXTRA_EMAIL, arrayOf("xxxxxx7@gmail.com"))
            btnemail.putExtra(Intent.EXTRA_SUBJECT, "Updated Subject")
            btnemail.putExtra("body", "testing")
            startActivity(btnemail)

        }
        btncall?.setOnClickListener {
            val btncall = Intent(Intent.ACTION_VIEW)
            btncall.data = Uri.parse("tel:xxxxxxxxxx")
            startActivity(btncall)
        }
    }
}
//val subject=subject?.text.toString().trim()