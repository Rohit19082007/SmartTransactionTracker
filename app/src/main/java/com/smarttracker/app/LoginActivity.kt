package com.smarttracker.app

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val email = findViewById<EditText>(R.id.email)
        val pass = findViewById<EditText>(R.id.password)
        val btn = findViewById<Button>(R.id.loginBtn)

        val auth = FirebaseAuth.getInstance()

        btn.setOnClickListener {
            auth.signInWithEmailAndPassword(
                email.text.toString(),
                pass.text.toString()
            ).addOnCompleteListener {
                if (it.isSuccessful) {
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }
        }
    }
}
