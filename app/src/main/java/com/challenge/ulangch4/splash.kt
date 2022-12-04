package com.challenge.ulangch4

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val intent = Intent(this,welcome::class.java)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(intent)
        }, 3000)
    }
}