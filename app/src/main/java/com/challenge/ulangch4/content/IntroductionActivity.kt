package com.challenge.ulangch4.content

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.viewpager2.widget.ViewPager2
import com.challenge.ulangch4.R
import com.challenge.ulangch4.Welcome
import com.challenge.ulangch4.databinding.ActivityIntroductionBinding
import com.google.android.material.tabs.TabLayoutMediator

private const val NUM_PAGES = 3

class IntroductionActivity : AppCompatActivity() {
    lateinit var binding: ActivityIntroductionBinding
    private lateinit var viewPager : ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroductionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setViewPager()
    }

    private fun setViewPager() {
        binding.apply {
            viewPager.apply {
                adapter = IntroAdapter(this@IntroductionActivity)
                currentItem = 0
            }
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            }.attach()
        }

    }
    override fun onBackPressed() {
//        val pagerAdapter = ScreenSlidePagerAdapter(this)
//        viewPager.adapter = pagerAdapter
        if (viewPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }

}



