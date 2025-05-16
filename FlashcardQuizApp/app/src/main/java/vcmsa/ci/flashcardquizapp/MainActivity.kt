package vcmsa.ci.flashcardquizapp

import android.content.Intent
import android.icu.text.CaseMap.Title
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private lateinit var appTitle: TextView
    private lateinit var welcomeMessage: TextView
    private lateinit var startBtn: Button
    private lateinit var exitBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        startBtn.setOnClickListener {

        }

        exitBtn.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }

    }
}