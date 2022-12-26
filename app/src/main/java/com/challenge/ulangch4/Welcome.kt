package com.challenge.ulangch4

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.challenge.ulangch4.databinding.ActivityWelcomeBinding
import com.google.android.material.snackbar.Snackbar

class Welcome : AppCompatActivity() {

    lateinit var binding: ActivityWelcomeBinding
    private var namapemain : String = "-"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        namapemain = intent.getStringExtra(KEY_NAME).toString()
        setUpView()
        snackBar()
        setAction()
//        Intent(this, Welcome::class.java)
    }

    private fun setUpView() {
        binding.apply {
            tvLawanPemain.text = namapemain
            tvLawanCom.text = namapemain
        }
    }

    private fun setAction() {
        binding.apply {
            ivLawanPemain.setOnClickListener {
                val intent = Intent(this@Welcome, MainActivity::class.java)
                startActivity(intent)
            }
            ivLawanCom.setOnClickListener {
                val intent = Intent(this@Welcome, MainActivity::class.java)
                startActivity(intent)
            }

        }
    }

    private fun snackBar() {
        Snackbar.make(binding.root, "Selamat Datang $namapemain !", Snackbar.LENGTH_LONG)
            .setAction("TUTUP") { view: View? -> }
            .setActionTextColor(resources.getColor(R.color.holo_red_light))
            .show()
    }
    companion object{
        const val KEY_NAME = "nama"
    }
}
