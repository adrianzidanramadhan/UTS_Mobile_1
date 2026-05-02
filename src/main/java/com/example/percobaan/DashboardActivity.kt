package com.example.percobaan

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)

        val content = findViewById<LinearLayout>(R.id.contentBox)

        val slide = AnimationUtils.loadAnimation(this, R.anim.slide_up)
        val fade = AnimationUtils.loadAnimation(this, R.anim.fade_in)

        content.startAnimation(slide)
        content.startAnimation(fade)

        val email = intent.getStringExtra("email") ?: "User"
        val welcomeText = findViewById<TextView>(R.id.greeting)

        welcomeText.text = "Hi, $email "

        val btn = findViewById<Button>(R.id.btnSeminar)

        btn.setOnClickListener {
            val intent = Intent(this, FormSeminarActivity::class.java)
            startActivity(intent)
        }
    }

}