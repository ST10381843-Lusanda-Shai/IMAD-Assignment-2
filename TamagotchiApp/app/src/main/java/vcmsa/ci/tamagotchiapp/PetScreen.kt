package vcmsa.ci.tamagotchiapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class PetScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pet_screen)

        val backBtn = findViewById<Button>(R.id.backBtn)
        val exitBtn = findViewById<Button>(R.id.exitBtn)

        backBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        exitBtn.setOnClickListener {
            finishAffinity()
            exitProcess( 0)
        }

    }
}