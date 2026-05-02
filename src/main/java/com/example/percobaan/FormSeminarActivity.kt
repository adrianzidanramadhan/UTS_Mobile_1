package com.example.percobaan

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import android.app.AlertDialog
import android.content.Intent

class FormSeminarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_seminar)

        val nama = findViewById<EditText>(R.id.nama)
        val email = findViewById<EditText>(R.id.email)
        val nohp = findViewById<EditText>(R.id.nohp)
        val genderGroup = findViewById<RadioGroup>(R.id.genderGroup)
        val spinner = findViewById<Spinner>(R.id.spinnerSeminar)
        val checkbox = findViewById<CheckBox>(R.id.checkbox)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        val seminarList = arrayOf(
            "Android Development",
            "Web Development",
            "UI/UX Design",
            "Cyber Security",
            "Artificial Intelligence"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            seminarList
        )
        spinner.adapter = adapter

        btnSubmit.setOnClickListener {

            val namaText = nama.text.toString().trim()
            val emailText = email.text.toString().trim()
            val nohpText = nohp.text.toString().trim()

            // VALIDASI

            if (namaText.isEmpty()) {
                nama.error = "Nama wajib diisi"
                nama.requestFocus()
                return@setOnClickListener
            }

            if (emailText.isEmpty()) {
                email.error = "Email wajib diisi"
                email.requestFocus()
                return@setOnClickListener
            }

            if (!emailText.contains("@")) {
                email.error = "Email tidak valid"
                email.requestFocus()
                return@setOnClickListener
            }

            if (nohpText.isEmpty()) {
                nohp.error = "Nomor HP wajib diisi"
                nohp.requestFocus()
                return@setOnClickListener
            }

            if (!nohpText.matches(Regex("^08[0-9]{8,11}$"))) {
                nohp.error = "Nomor harus 08 dan 10-13 digit"
                nohp.requestFocus()
                return@setOnClickListener
            }

            if (genderGroup.checkedRadioButtonId == -1) {
                Toast.makeText(this, "Pilih jenis kelamin", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedGenderId = genderGroup.checkedRadioButtonId
            val gender = findViewById<RadioButton>(selectedGenderId).text.toString()

            val seminar = spinner.selectedItem.toString()

            if (!checkbox.isChecked) {
                Toast.makeText(this, "Harus menyetujui data", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            AlertDialog.Builder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah data yang Anda isi sudah benar?")
                .setPositiveButton("Ya") { _, _ ->

                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra("nama", namaText)
                    intent.putExtra("email", emailText)
                    intent.putExtra("nohp", nohpText)
                    intent.putExtra("gender", gender)
                    intent.putExtra("seminar", seminar)

                    startActivity(intent)
                }
                .setNegativeButton("Tidak", null)
                .show()

        }
    }
}