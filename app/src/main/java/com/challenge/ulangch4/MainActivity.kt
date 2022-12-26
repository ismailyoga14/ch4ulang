package com.challenge.ulangch4

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.widget.doOnTextChanged
import com.challenge.ulangch4.databinding.ActivityAlertdialogBinding


class MainActivity : AppCompatActivity() {
    lateinit var ivbatu: AppCompatImageView
    lateinit var ivgunting: AppCompatImageView
    lateinit var ivkertas: AppCompatImageView
    lateinit var ivrefresh: AppCompatImageView
    lateinit var tvversus: AppCompatTextView
    lateinit var ivkertascom: AppCompatImageView
    lateinit var ivbatucom: AppCompatImageView
    lateinit var ivguntingcom: AppCompatImageView
    lateinit var ivclose: AppCompatImageView
    lateinit var tvpemain: AppCompatTextView
    private var namapemain: String = "-"

    private val listComp = arrayOf("kertas", "gunting", "batu").random()
    private var player: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        namapemain = intent.getStringExtra(KEY_NAME).toString()
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
        ivclose = findViewById(R.id.iv_close)
        tvpemain = findViewById(R.id.tv_pemain)

        tvpemain.text = namapemain

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
        ivclose.setOnClickListener {
            val intent = Intent(this@MainActivity, IntroductionActivity::class.java)
            startActivity(intent)
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
        } else if (com == "kertas" && player == "batu") {
            showWinner(1)
        } else if (com == "gunting" && player == "batu") {
            showWinner(0)
        } else if (com == "gunting" && player == "gunting") {
            showWinner(2)
        } else if (com == "batu" && player == "gunting") {
            showWinner(1)
        } else if (com == "kertas" && player == "gunting") {
            showWinner(0)
        }
    }

    private fun showWinner(res: Int) {
        when (res) {
            0 -> {
                val desc = "kamu menang"
                dialogConfirmation("yoga", desc)
                tvversus.setText(desc)
            } //player 1 win
            1 -> {
                val desc = "com menang"
                dialogConfirmation("yoga", desc)
                tvversus.setText(desc)
            }//com 2 win
            else -> {
                val desc = "seri"
                dialogConfirmation("yoga", desc)
                tvversus.setText(desc)
            } //draw

        }
    }

    private fun clearScore() {
        finish();
        overridePendingTransition(0, 0);
        startActivity(getIntent());
        overridePendingTransition(0, 0);
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
        const val KEY_NAME ="nama"
        const val close = ""
        const val batucom = "batucom"
        const val kertascom = "kertascom"
        const val guntingcom = "guntingcom"
    }


    private fun dialogConfirmation(nameData: String, desc: String) {
        val layoutInflater = LayoutInflater.from(this)
        val bindingFragment: ActivityAlertdialogBinding =
            ActivityAlertdialogBinding.inflate(layoutInflater)
        val dialogView = bindingFragment.root
        val alert = AlertDialog.Builder(this)
        alert.apply {
            setView(dialogView)
            setCancelable(false)
        }
        val alertDialog = alert.create()
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        bindingFragment.apply {
            btnPlayAgain.setOnClickListener() {
                Toast.makeText(this@MainActivity, "Bermain Lagi", Toast.LENGTH_SHORT)
                    .show()
                clearScore()
            }
            btnToMenu.setOnClickListener {
                Toast.makeText(this@MainActivity, "Kembali ke Menu", Toast.LENGTH_SHORT)
                    .show()
                val intent = Intent(this@MainActivity, Welcome::class.java)
                startActivity(intent)
            }
            tvTitle.setText(desc)
                // TODO: set string text view with desc

        }
        alertDialog.show()
    }
}