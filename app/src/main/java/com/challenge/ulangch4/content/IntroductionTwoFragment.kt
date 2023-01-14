package com.challenge.ulangch4.content

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.challenge.ulangch4.R

class IntroductionTwoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_introduction_two, container, false)
    }

    companion object {
        fun newInstance(page: Int) =
            IntroductionTwoFragment()
    }
}