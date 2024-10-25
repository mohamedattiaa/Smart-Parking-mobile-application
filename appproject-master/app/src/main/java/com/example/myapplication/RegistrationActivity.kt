package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore

class RegistrationActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth;


  /*  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        val adresseemail =findViewById<TextView>(R.id.editTextTextEmailAddress)
        val nom =findViewById<TextView>(R.id.editTextTextEmailAddresss)
        val adresseip =findViewById<TextView>(R.id.editTextTextEmailAddressss)
        val credit =findViewById<TextView>(R.id.editTextTextEmailAddresssss)
        val mdp =findViewById<TextView>(R.id.editTextTextPassword)
        val enregistrement = findViewById<Button>(R.id.button3)
        auth = Firebase.auth
        val mail = adresseemail.text.toString()
        val name = nom.text.toString()
        val ip = adresseip.text.toString()
        val cred = credit.text.toString()
        val motdp=mdp.text.toString()

        // creation de l'utilisateur dans le module authentification de firebase

        auth.createUserWithEmailAndPassword(mail,motdp).addOnCompleteListener{task ->
           if(task.isSuccessful){
        // creation de l'utilisateur dans le module firestore
               val db = Firebase.firestore
               val user = hashMapOf(
                   "email" to mail ,
                   "nom" to name,
                   "adresse ip " to ip,
                   "credit" to cred,
               )
               val currentuser =auth.currentUser
               db.collection("users").document(currentuser!!.uid).set(user).addOnSuccessListener { val intentToMainActivity : Intent = Intent (this, MainActivity ::class.java)
                   startActivity(intentToMainActivity)  }
                         }
           else { Toast.makeText(this, "nope ", Toast.LENGTH_LONG).show()}
    }
}*/
  override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_registration)

      // Initializing views
      val adresseemail = findViewById<TextView>(R.id.editTextTextEmailAddress)
      val nom = findViewById<TextView>(R.id.editTextTextEmailAddresss)
      val adresseip = findViewById<TextView>(R.id.editTextTextEmailAddressss)
      val credit = findViewById<TextView>(R.id.editTextTextEmailAddresssss)
      val mdp = findViewById<TextView>(R.id.editTextTextPassword)
      val enregistrement = findViewById<Button>(R.id.button3)

      // Initialize Firebase Authentication
      auth = Firebase.auth

      enregistrement.setOnClickListener {
          val mail = adresseemail.text.toString()
          val name = nom.text.toString()
          val ip = adresseip.text.toString()
          val cred = credit.text.toString()
          val motdp = mdp.text.toString()

          // Ensure none of the fields is empty
          if (mail.isEmpty() || name.isEmpty() || ip.isEmpty() || cred.isEmpty() || motdp.isEmpty()) {
              Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
              return@setOnClickListener
          }

          // Create the user in Firebase Authentication module
          auth.createUserWithEmailAndPassword(mail, motdp).addOnCompleteListener { task ->
              if (task.isSuccessful) {
                  // Create the user in Firestore module
                  val db = Firebase.firestore
                  val user = hashMapOf(
                      "email" to mail,
                      "nom" to name,
                      "adresse ip" to ip,
                      "credit" to cred
                  )
                  val currentuser = auth.currentUser
                  db.collection("users").document(currentuser!!.uid).set(user)
                      .addOnSuccessListener {
                          // If registration is successful, navigate to MainActivity
                          val intentToMainActivity: Intent = Intent(this, MainActivity::class.java)
                          startActivity(intentToMainActivity)
                      }
              } else {
                  // If registration fails, show a toast message
                  Toast.makeText(this, "Registration failed", Toast.LENGTH_LONG).show()
              }
          }
      }
  }

}