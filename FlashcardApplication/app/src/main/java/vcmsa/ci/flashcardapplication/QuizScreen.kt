package vcmsa.ci.flashcardapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class QuizScreen : AppCompatActivity() {

    private lateinit var questionTextView: TextView
    private lateinit var feedbackTextView: TextView
    private lateinit var trueBtn: Button
    private lateinit var falseBtn: Button
    private lateinit var nextBtn: Button
    private lateinit var exit1Btn: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz_screen)

        val questionTextView: TextView = findViewById(R.id.questionTextView)
        val feedback: TextView = findViewById(R.id.feedbackTextView)
        val trueBtn: Button = findViewById(R.id.trueBtn)
        val falseBtn: Button = findViewById(R.id.falseBtn)
        val nextBtn: Button = findViewById(R.id.nextBtn)
        val exit1Btn: Button = findViewById(R.id.exit1Btn)

        nextBtn.setOnClickListener {
            val intent = Intent(this, ScoreScreen::class.java)
            startActivity(intent)
        }

        exit1Btn.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }

    }
}