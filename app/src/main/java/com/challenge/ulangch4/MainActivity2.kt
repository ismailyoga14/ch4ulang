package com.challenge.ulangch4

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.challenge.ulangch4.content.IntroductionActivity
import com.challenge.ulangch4.databinding.ActivityAlertdialogBinding

class MainActivity2 : AppCompatActivity() {
    private var namapemain: String = ""
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

    private val listComp = arrayOf("kertas", "gunting", "batu").random()
    private var player: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        namapemain = intent.getStringExtra(MainActivity.KEY_NAME).toString()
        setUpView()
        setUpAction()
    }


    private fun setUpView() {
        ivbatu = findViewById(R.id.ivbatu)
        ivgunting = findViewById(R.id.ivgunting)
        ivkertas = findViewById(R.id.ivkertas)
        ivrefresh = findViewById(R.id.ivrefresh)
        tvversus = findViewById(R.id.tvvs)
        ivbatucom = findViewById(R.id.ivbatucom)
        ivguntingcom = findViewById(R.id.ivguntingcom)
        ivkertascom = findViewById(R.id.ivkertascom)
        ivclose = findViewById(R.id.ivclose)
        tvpemain = findViewById(R.id.tvpemain)

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
            val intent = Intent(this@MainActivity2, IntroductionActivity::class.java)
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
                val desc = "$namapemain menang"
                dialogConfirmation("yoga", desc)
                tvversus.setText(desc)
            } //player 1 win
            1 -> {
                val desc = "Pemain 2 menang"
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
        const val KEY_NAME = "nama"
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
                Toast.makeText(this@MainActivity2, "Bermain Lagi", Toast.LENGTH_SHORT)
                    .show()
                clearScore()
            }
            btnToMenu.setOnClickListener {
                Toast.makeText(this@MainActivity2, "Kembali ke Menu Utama", Toast.LENGTH_SHORT)
                    .show()
                val intent = Intent(this@MainActivity2, Welcome::class.java)
                intent.putExtra(KEY_NAME, namapemain)
                startActivity(intent)
            }
            tvTitle.setText(desc)

        }
        alertDialog.show()
    }
}