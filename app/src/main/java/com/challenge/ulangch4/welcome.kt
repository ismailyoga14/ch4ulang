package com.challenge.ulangch4

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class welcome: AppCompatActivity() {

    lateinit var btnwelcome: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        setAction()
        Intent(this, MainActivity::class.java)
    }

    private fun setAction() {
        btnwelcome.setOnClickListener {
            (R.layout.activity_main)
        }
    }
}