package vcmsa.ci.flashcardapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class ScoreScreen : AppCompatActivity() {

    private lateinit var next1Btn: Button
    private lateinit var exit2Btn: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score_screen)

        val next1Btn: Button = findViewById(R.id.next1Btn)
        val exit2Btn: Button = findViewById(R.id.exit2Btn)

        next1Btn.setOnClickListener {
            val intent = Intent(this, ScoreScreen::class.java)
            startActivity(intent)
        }

        exit2Btn.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }

    }
}