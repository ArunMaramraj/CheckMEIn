package com.ml.quaterion.facenetdetection

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginactivity)

        // Get references to the UI elements
        usernameEditText = findViewById(R.id.username)
        passwordEditText = findViewById(R.id.password)
        loginButton = findViewById(R.id.loginButton)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (isValidCredentials(username, password)) {
                // Start the MainActivity
                val intent = Intent(this@LoginActivity, SelectClass::class.java)
                startActivity(intent)
                finish() // close the login activity
            } else {
                // Show an error message
                Toast.makeText(this@LoginActivity, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isValidCredentials(username: String, password: String): Boolean {
        // Check if the username and password match the ones stored on the server/database
        // You can use a web API or a database query to verify the user's credentials
        // Return true if the credentials are valid, false otherwise
        // This is just an example, you should replace this with your own implementation
        return (username == "admin" && password == "admin")
    }
}
