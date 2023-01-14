package com.challenge.ulangch4

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.challenge.ulangch4.content.IntroductionActivity

class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val splashTime: Long = 3000

        Handler().postDelayed({
            val intent = Intent(this, IntroductionActivity::class.java)
            startActivity(intent)
            finish()
        }, splashTime)

    }

}