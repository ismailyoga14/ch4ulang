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

    private fun setName() {
        binding.apply {
            val etnama = findViewById<EditText>(R.id.et_nama)
            intent = Intent(this@IntroductionActivity, Welcome::class.java)
            intent.putExtra("", etnama.getText().toString())
            startActivity(intent);
        }
    }



    override fun onBackPressed() {
//        val pagerAdapter = ScreenSlidePagerAdapter(this)
//        viewPager.adapter = pagerAdapter
        if (viewPager.currentItem == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed()
        } else {
            // Otherwise, select the previous step.
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }
//
//    /**
//     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
//     * sequence.
//     */
//    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
//        override fun getItemCount(): Int = NUM_PAGES
//
//        override fun createFragment(position: Int): Fragment = ScreenSlidePageFragment()
//    }

}



