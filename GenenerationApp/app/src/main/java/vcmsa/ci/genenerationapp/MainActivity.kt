package vcmsa.ci.genenerationapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.findViewTreeViewModelStoreOwner

class MainActivity : AppCompatActivity() {

    private var yearInput : TextView? = null
    private var genText : TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        yearInput = findViewById(R.id.yearInput)
        genText = findViewById(R.id.genText)

        val checkBtn = findViewById<Button>(R.id.checkBtn)

        checkBtn.setOnClickListener {
            checkGeneration()
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun checkGeneration() {
        when (yearInput?.text.toString().trim().toInt()){
            in 1901 .. 1927 -> genText?.text = "The Greatest Generation"
            in 1928 .. 1945 -> genText?.text = "The Silent Generation"
            in 1946 .. 1964 -> genText?.text = "The Baby Boomer Generation"
            in 1965 .. 1980 -> genText?.text = "Generation X"
            in 1981 .. 1996 -> genText?.text = "Millennials"
            in 1997 .. 2012 -> genText?.text = "Gen Z"
            in 2013 .. 2025 -> genText?.text = "Gen Alpha"

            else ->{
                genText?.text = "MY GOLLY, YOUR AN IMPOSTER!!!!!(your birth year was not found)"
            }
        }
    }

}