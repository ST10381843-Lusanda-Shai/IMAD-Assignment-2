package vcmsa.ci.flashcardapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score_screen)

        val next1Btn = findViewById<Button>(R.id.next1Btn)

        next1Btn.setOnClickListener {
            val intent = Intent(this, ScoreScreen::class.java)
            startActivity(intent)
        }



    }
}