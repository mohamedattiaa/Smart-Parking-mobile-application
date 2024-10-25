package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class PagedacceuilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pagedacceuil)
        val tvhello = findViewById<TextView>(R.id.textView5)
        val email = intent.getStringExtra("email",)
        tvhello.text= "welcome to our smart parking " +
                "$email"
        val boutton2 =findViewById<Button>(R.id.button2)
        boutton2.setOnClickListener{
        val intentToMainActivity3 : Intent = Intent (this, MainActivity3 ::class.java)
        startActivity(intentToMainActivity3)
        }
    }
}
