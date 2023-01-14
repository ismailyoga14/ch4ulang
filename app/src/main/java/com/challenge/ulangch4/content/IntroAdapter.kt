package com.challenge.ulangch4.content

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class IntroAdapter(FragmentActivity: FragmentActivity):
FragmentStateAdapter(FragmentActivity){

    private val fragmentsdata = listOf(
        IntroductionOneFragment.newInstance(FIRST),
        IntroductionTwoFragment.newInstance(SECOND),
        IntroductionThreeFragment.newInstance(LAST),
    )
    companion object{
        const val FIRST = 0
        const val SECOND = 1
        const val LAST = 2
    }
    override fun getItemCount(): Int {
        return  fragmentsdata.size
    }

    override fun createFragment(position: Int): Fragment = fragmentsdata[position]


}


