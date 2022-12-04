package com.challenge.ulangch4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView


class MainActivity : AppCompatActivity() {
    lateinit var ivbatu: AppCompatImageView
    lateinit var ivgunting: AppCompatImageView
    lateinit var ivkertas: AppCompatImageView
    lateinit var ivrefresh: AppCompatImageView
    lateinit var tvversus: AppCompatTextView
    lateinit var ivkertascom: AppCompatImageView
    lateinit var ivbatucom: AppCompatImageView
    lateinit var ivguntingcom: AppCompatImageView

    private val listComp =arrayOf("kertas", "gunting", "batu").random()
    private var player: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpView()
        setUpAction()
    }


    private fun setUpView() {
        ivbatu = findViewById(R.id.iv_batu)
        ivgunting = findViewById(R.id.iv_gunting)
        ivkertas = findViewById(R.id.iv_kertas)
        ivrefresh = findViewById(R.id.iv_refresh)
        tvversus = findViewById(R.id.tv_vs)
        ivbatucom = findViewById(R.id.iv_batucom)
        ivguntingcom = findViewById(R.id.iv_guntingcom)
        ivkertascom = findViewById(R.id.iv_kertascom)
    }

    private fun setUpAction() {
        ivrefresh.setOnClickListener {
            (R.layout.activity_main)
            clearScore()
        }

        ivkertas.setOnClickListener {
            player = "kertas"
            setSelectionPlayer(kertas)
            rundCom()
        }
        ivgunting.setOnClickListener {
            player = "gunting"
            setSelectionPlayer(gunting)
            rundCom()
        }
        ivbatu.setOnClickListener {
            player = "batu"
            setSelectionPlayer(batu)
            rundCom()
        }
    }

    private fun rundCom() {
        setSelectionCom(listComp)
        checkWinner(listComp)
    }

    private fun checkWinner(com: String) {
        if (com == "kertas" && player == "kertas") {
            showWinner(2)
        } else if (com == "gunting" && player == "kertas") {
            showWinner(1)
        } else if (com == "batu" && player == "kertas") {
            showWinner(0)
        } else if (com == "batu" && player == "batu") {
            showWinner(2)
        }else if (com == "kertas" && player == "batu") {
            showWinner(1)
        }else if (com == "gunting" && player == "batu") {
            showWinner(0)
        }else if (com == "gunting" && player == "gunting") {
            showWinner(2)
        }else if (com == "batu" && player == "gunting") {
            showWinner(1)
        }else if (com == "kertas" && player == "gunting") {
            showWinner(0)
        }
    }

    private fun showWinner(res: Int) {
        when (res) {
            //TODO: create func for change image VS
            0 -> tvversus.setText("kamu menang") //player 1 win
            1 -> tvversus.setText("com menang") //com 2 win
            else -> tvversus.setText("seri") //draw
        }
    }

    private fun clearScore() {
        finish();
        overridePendingTransition( 0, 0);
        startActivity(getIntent());
        overridePendingTransition( 0, 0);
    }

    private fun setSelectionPlayer(typeSelection: String) {
        when (typeSelection) {
            kertas -> {
                ivkertas.setBackgroundResource(R.drawable.bg_ellipse_selector)
            }
            gunting -> {
                ivgunting.setBackgroundResource(R.drawable.bg_ellipse_selector)
            }
            batu -> {
                ivbatu.setBackgroundResource(R.drawable.bg_ellipse_selector)
            }
        }
    }

    private fun setSelectionCom(typeSelection: String) {
        when (typeSelection) {
            kertas -> {
                ivkertascom.setBackgroundResource(R.drawable.bg_ellipse_selector)
            }
            gunting -> {
                ivguntingcom.setBackgroundResource(R.drawable.bg_ellipse_selector)
            }
            batu -> {
                ivbatucom.setBackgroundResource(R.drawable.bg_ellipse_selector)
            }
        }
    }

    private fun resultSet(resultGame: String) {
        when (resultGame) {
            kertas -> {
                tvversus.setBackgroundResource(R.drawable.bg_ellipse_selector)
            }
            gunting -> {
                tvversus.setBackgroundResource(R.drawable.bg_ellipse_selector)
            }
            batu -> {
                tvversus.setBackgroundResource(R.drawable.bg_ellipse_selector)
            }
        }
    }

    companion object {
        const val kertas = "kertas"
        const val gunting = "gunting"
        const val batu = "batu"
        const val batucom = "batucom"
        const val kertascom = "kertascom"
        const val guntingcom = "guntingcom"
    }
}