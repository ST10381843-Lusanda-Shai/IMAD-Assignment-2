package vcmsa.ci.tamagotchiapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val petImage: ImageView = findViewById(R.id.kittyHi)

        val welcomeBtn: Button = findViewById(R.id.welcomeBtn)
        welcomeBtn.setOnClickListener {
            startActivity(Intent(this, PetScreen::class.java))
        }

        }
    }