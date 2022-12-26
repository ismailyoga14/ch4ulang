package com.challenge.ulangch4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TableLayout
import com.challenge.ulangch4.databinding.ActivityIntroductionBinding
import com.google.android.material.tabs.TabLayoutMediator

class IntroductionActivity : AppCompatActivity() {
    lateinit var binding: ActivityIntroductionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroductionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setViewPager()
    }

    private fun setViewPager() {
        binding.apply {
            vpSlider.apply {
                adapter = IntroAdapter(this@IntroductionActivity)
                currentItem = 0
            }
            TabLayoutMediator(tabIndicator,vpSlider){ tab,position ->
            }.attach()
        }



    }
    private fun setName() {
        binding.apply {
            val etnama = findViewById<EditText>(R.id.et_nama)
            intent = Intent(this@IntroductionActivity, Welcome::class.java)
            intent.putExtra("", etnama.getText().toString())
            startActivity(intent);
        }
    }
}



