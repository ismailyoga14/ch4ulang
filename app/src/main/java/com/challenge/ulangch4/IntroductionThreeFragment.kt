package com.challenge.ulangch4

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.challenge.ulangch4.Welcome.Companion.KEY_NAME
import com.challenge.ulangch4.databinding.FragmentIntroductionThreeBinding

//const val PESAN = "com.jagongoding.aplikasipertama.PESAN"

class IntroductionThreeFragment : Fragment() {
    lateinit var binding: FragmentIntroductionThreeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentIntroductionThreeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAction()
    }
    private fun setUpAction() {
        binding.apply {
            etNama.doOnTextChanged { text, start, before, count ->
                if ((text?.length?:0)>0){
                    btnMulai.visibility = View.VISIBLE
                }else{
                    btnMulai.visibility = View.GONE
                }
            }
            btnMulai.setOnClickListener { viewClick ->
                val intent = Intent(requireActivity(), Welcome::class.java)
                intent.putExtra(KEY_NAME, etNama.text.toString())
                startActivity(intent)
            }
        }
    }


    companion object {
        fun newInstance(page: Int) = IntroductionThreeFragment()

    }
}