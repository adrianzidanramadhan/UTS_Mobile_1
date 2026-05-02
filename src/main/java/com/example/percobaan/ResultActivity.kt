package com.example.percobaan

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val nama = intent.getStringExtra("nama")
        val email = intent.getStringExtra("email")
        val nohp = intent.getStringExtra("nohp")
        val gender = intent.getStringExtra("gender")
        val seminar = intent.getStringExtra("seminar")

        findViewById<TextView>(R.id.txtNama).text = "Nama: $nama"
        findViewById<TextView>(R.id.txtEmail).text = "Email: $email"
        findViewById<TextView>(R.id.txtNoHp).text = "No HP: $nohp"
        findViewById<TextView>(R.id.txtGender).text = "Gender: $gender"
        findViewById<TextView>(R.id.txtSeminar).text = "Seminar: $seminar"

        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}