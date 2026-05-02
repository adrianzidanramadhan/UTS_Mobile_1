package com.example.percobaan

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val emailInput = findViewById<EditText>(R.id.email)
        val passwordInput = findViewById<EditText>(R.id.password)
        val loginBtn = findViewById<Button>(R.id.loginBtn)

        loginBtn.setOnClickListener {

            val emailText = emailInput.text.toString().trim()
            val passwordText = passwordInput.text.toString().trim()

            // VALIDASI EMAIL
            if (emailText.isEmpty()) {
                emailInput.error = "Email wajib diisi"
                emailInput.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
                emailInput.error = "Format email tidak valid"
                emailInput.requestFocus()
                return@setOnClickListener
            }

            // VALIDASI PASSWORD
            if (passwordText.isEmpty()) {
                passwordInput.error = "Password wajib diisi"
                passwordInput.requestFocus()
                return@setOnClickListener
            }

            if (passwordText.length < 4) {
                passwordInput.error = "Password minimal 4 karakter"
                passwordInput.requestFocus()
                return@setOnClickListener
            }

            // PINDAH KE DASHBOARD
            val intent = Intent(this, DashboardActivity::class.java)
            intent.putExtra("email", emailText)
            startActivity(intent)
        }
    }
}