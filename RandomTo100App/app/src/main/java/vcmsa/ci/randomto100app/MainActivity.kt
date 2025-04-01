package vcmsa.ci.randomto100app

import android.health.connect.datatypes.units.Length
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private var randomNumber : Int = 0
    private var gvnNum : EditText? = null
    private var textOuput : TextView? = null
    private var backPressed = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        generateRandomNumber()

        gvnNum = findViewById(R.id.gvnNum)
        textOuput = findViewById(R.id.textOutput)

        val guessBtn = findViewById<Button>(R.id.guessBtn)
        val clearBtn = findViewById<Button>(R.id.clearBtn)
        val exitBtn = findViewById<Button>(R.id.exitBtn)

        guessBtn.setOnClickListener {
            compare()
        }

        clearBtn.setOnClickListener {
            gvnNum?.text?.clear()
            generateRandomNumber()
            textOuput?.text = ""
        }

        exitBtn.setOnClickListener {
            moveTaskToBack(true)
            android.os.Process.killProcess(android.os.Process.myPid())
            exitProcess(1)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun generateRandomNumber() {
        randomNumber = Random.nextInt(1,100)
    }
    private fun isNotEmpty() : Boolean {
        var b = true
        if (gvnNum?.text.toString().trim().isEmpty()){
            b = false
        }
        return b
    }
    private fun compare() {
        if (isNotEmpty()){

            val gvnNum = gvnNum?.text.toString().trim().toInt()

            if (gvnNum == randomNumber) {
                textOuput?.text = "Great! $gvnNum is the correct number."
            }else
            if (gvnNum > randomNumber){
                textOuput?.text = "Sorry, $gvnNum is too high."
            }else
            if (gvnNum < randomNumber){
                textOuput?.text = "Sorry, $gvnNum is too low."
            }
        }
    }

    override fun onBackPressed() {
        if (backPressed + 2000 > System.currentTimeMillis()){
            super.onBackPressed()
        }
        else{
            Toast.makeText(this, "Press the button again to exit!", Toast.LENGTH_LONG).show()
        }
        backPressed = System.currentTimeMillis()
    }
}