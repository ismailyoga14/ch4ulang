package com.challenge.ulangch4

import android.annotation.SuppressLint
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
import com.challenge.ulangch4.content.IntroductionActivity
import com.challenge.ulangch4.databinding.ActivityAlertdialogBinding

class GameOn : AppCompatActivity() {
    private var namapemain: String = ""
    lateinit var ivbatu1: AppCompatImageView
    lateinit var ivgunting1: AppCompatImageView
    lateinit var ivkertas1: AppCompatImageView
    lateinit var ivrefresh: AppCompatImageView
    lateinit var tvversus: AppCompatTextView
    lateinit var ivkertas2: AppCompatImageView
    lateinit var ivbatu2: AppCompatImageView
    lateinit var ivgunting2: AppCompatImageView
    lateinit var ivclose: AppCompatImageView
    lateinit var tvpemain: AppCompatTextView

    private val listComp = arrayOf("kertas", "gunting", "batu").random()
    private var player1: String = ""
    private var player2: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_two)
        namapemain = intent.getStringExtra(MainActivity.KEY_NAME).toString()
        setUpView()
        setUpAction()
    }

    private fun setUpView() {
        ivbatu1 = findViewById(R.id.iv_batu)
        ivgunting1 = findViewById(R.id.iv_gunting)
        ivkertas1 = findViewById(R.id.iv_kertas)
        ivrefresh = findViewById(R.id.iv_refresh)
        tvversus = findViewById(R.id.tv_vs)
        ivbatu2 = findViewById(R.id.iv_batucom)
        ivgunting2 = findViewById(R.id.iv_guntingcom)
        ivkertas2 = findViewById(R.id.iv_kertascom)
        ivclose = findViewById(R.id.iv_close)
        tvpemain = findViewById(R.id.tv_pemain)
        tvpemain.text = namapemain
    }

    @SuppressLint("ResourceType")
    private fun setUpAction() {
        // set button refresh
        ivrefresh.setOnClickListener {
            (R.layout.activity_main)
            clearScore()
        }

        // set button close game
        ivclose.setOnClickListener {
            val intent = Intent(this@GameOn, IntroductionActivity::class.java)
            startActivity(intent)
        }

        // set button for player 1
        ivkertas1.setOnClickListener {
            player1 = "kertas"
            setSelectionPlayer(kertas)
            ivkertas1.isEnabled = true
            ivgunting1.isEnabled = false
            ivbatu1.isEnabled = false
            validateInput()
        }
        ivgunting1.setOnClickListener {
            player1 = "gunting"
            setSelectionPlayer(gunting)
            ivkertas1.isEnabled = false
            ivbatu1.isEnabled = false
            validateInput()
        }
        ivbatu1.setOnClickListener {
            player1 = "batu"
            setSelectionPlayer(batu)
            ivkertas1.isEnabled = false
            ivgunting1.isEnabled = false
            validateInput()
        }

        // set button for player 2
        ivkertas2.setOnClickListener {
            player2 = "kertas"
            setSelectionCom(kertas)
            ivgunting2.isEnabled = false
            ivbatu2.isEnabled = false
            validateInput()
        }
        ivgunting2.setOnClickListener {
            player2 = "gunting"
            setSelectionCom(gunting)
            ivkertas2.isEnabled = false
            ivbatu2.isEnabled = false
            validateInput()
        }
        ivbatu2.setOnClickListener {
            player2 = "batu"
            setSelectionCom(batu)
            ivkertas2.isEnabled = false
            ivgunting2.isEnabled = false
            validateInput()
        }
    }

    // validate value player 1 && player 2
    private fun validateInput() {
        if (player1 != null && player2 != null) {
            checkWinner()
        }
    }

    // logic for check winner
    private fun checkWinner() {
        if (player2 == "kertas" && player1 == "kertas") {
            showWinner(2)
        } else if (player2 == "gunting" && player1 == "kertas") {
            showWinner(1)
        } else if (player2 == "batu" && player1 == "kertas") {
            showWinner(0)
        } else if (player2 == "batu" && player1 == "batu") {
            showWinner(2)
        } else if (player2 == "kertas" && player1 == "batu") {
            showWinner(1)
        } else if (player2 == "gunting" && player1 == "batu") {
            showWinner(0)
        } else if (player2 == "gunting" && player1 == "gunting") {
            showWinner(2)
        } else if (player2 == "batu" && player1 == "gunting") {
            showWinner(1)
        } else if (player2 == "kertas" && player1 == "gunting") {
            showWinner(0)
        }
    }

    private fun showWinner(res: Int) {
        when (res) {
            0 -> {
                val desc = "$namapemain menang"
                dialogConfirmation(desc)
                tvversus.setText(desc)
            } //player 1 win
            1 -> {
                val desc = "Pemain 2 menang"
                dialogConfirmation(desc)
                tvversus.setText(desc)
            }//com 2 win
            else -> {
                val desc = "seri"
                dialogConfirmation(desc)
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
                ivkertas1.setBackgroundResource(R.drawable.bg_ellipse_selector)
            }
            gunting -> {
                ivgunting1.setBackgroundResource(R.drawable.bg_ellipse_selector)
            }
            batu -> {
                ivbatu1.setBackgroundResource(R.drawable.bg_ellipse_selector)
            }
        }
    }

    private fun setSelectionCom(typeSelection: String) {
        when (typeSelection) {
            kertas -> {
                ivkertas2.setBackgroundResource(R.drawable.bg_ellipse_selector)
            }
            gunting -> {
                ivgunting2.setBackgroundResource(R.drawable.bg_ellipse_selector)
            }
            batu -> {
                ivbatu2.setBackgroundResource(R.drawable.bg_ellipse_selector)
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
    }

    private fun dialogConfirmation(desc: String) {
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
                Toast.makeText(this@GameOn, "Bermain Lagi", Toast.LENGTH_SHORT)
                    .show()
                clearScore()
            }
            btnToMenu.setOnClickListener {
                Toast.makeText(this@GameOn, "Kembali ke Menu Utama", Toast.LENGTH_SHORT)
                    .show()
                val intent = Intent(this@GameOn, Welcome::class.java)
                intent.putExtra(KEY_NAME, namapemain)
                startActivity(intent)
            }
            tvTitle.setText(desc)

        }
        alertDialog.show()
    }
}