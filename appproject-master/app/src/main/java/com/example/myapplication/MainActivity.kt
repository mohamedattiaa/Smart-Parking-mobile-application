package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {
    fun isValidEmail(email: String): Boolean {
        val emailRegex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\$")
        return emailRegex.matches(email)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var auth: FirebaseAuth;
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button4 = findViewById<Button>(R.id.button4)
        val button3 = findViewById<Button>(R.id.button3)
        val email = findViewById<TextView>(R.id.editTextTextEmailAddress)
        val mdp =findViewById<TextView>(R.id.editTextTextPassword)
        auth = Firebase.auth

        button3.setOnClickListener{
           /* val txtEmail = email.text.toString()
            val txt = mdp.text.toString()
            if(isValidEmail(txtEmail)){
            Toast.makeText(this, "adresse email est valide ",Toast.LENGTH_LONG).show()
                val intentToPagedacceuilActivity : Intent = Intent(this, PagedacceuilActivity :: class.java)
                email.setText("")
                mdp.setText("")
                intentToPagedacceuilActivity.putExtra("email",txtEmail)
                startActivity(intentToPagedacceuilActivity)
            }

            else if(txtEmail.isEmpty()||txt.isEmpty()){
            Toast.makeText(this, "le champ est vide ",Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(this, "adress email est non valide",Toast.LENGTH_LONG).show()
            }*/
            val txtEmail = email.text.toString()
            val txt = mdp.text.toString()
            auth.signInWithEmailAndPassword(txtEmail,txt).addOnCompleteListener { task ->
                if (task.isSuccessful)
                {val intentToPagedacceuilActivity : Intent = Intent(this, PagedacceuilActivity :: class.java)
                    email.setText("")
                    mdp.setText("")
                    intentToPagedacceuilActivity.putExtra("email", txtEmail)
                    startActivity(intentToPagedacceuilActivity)
            }
                else if(txtEmail.isEmpty()||txt.isEmpty()){
                    Toast.makeText(this, "le champ est vide ",Toast.LENGTH_LONG).show()
                }
                else
                {
                    Toast.makeText(this, "adress email est non valide",Toast.LENGTH_LONG).show()
                }

        }
    }
        button4.setOnClickListener{
            val intentToRegistrationActivity : Intent = Intent(this, RegistrationActivity :: class.java)
            startActivity(intentToRegistrationActivity)

        }

 }}