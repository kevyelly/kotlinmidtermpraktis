package com.example.practice

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView (R.layout.login)
        val et_username = findViewById<EditText>(R.id.et_username)
        val et_password = findViewById<EditText>(R.id.et_password)
        val btnlogin = findViewById<Button>(R.id.btnlogin)
        val app = application as MyApp

        btnlogin.setOnClickListener{
            val username = et_username.text.toString().trim()
            val password = et_password.text.toString().trim()
            if(username.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Please input all fields!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if(username == app.username && password == app.password){
                Toast.makeText(this, "Login succesful!", Toast.LENGTH_SHORT).show();
                startActivity(Intent(this, DataEntryActivity::class.java))
                finish()
            }else{
                Toast.makeText(this, "Incorrect credentials!!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}