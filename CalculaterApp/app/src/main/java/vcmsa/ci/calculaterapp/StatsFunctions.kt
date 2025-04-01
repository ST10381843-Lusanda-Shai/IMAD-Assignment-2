package vcmsa.ci.calculaterapp

import android.content.Intent
import android.os.Bundle
import android.provider.BlockedNumberContract.BlockedNumbers
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class StatsFunctions : AppCompatActivity() {

    private lateinit var statNumber : TextView
    private lateinit var addBtn : Button
    private lateinit var memNumbers : TextView
    private lateinit var textView6 : TextView
    private lateinit var clearBtn : Button
    private lateinit var avgBtn : Button
    private lateinit var minmaxBtn : Button
    private lateinit var backBtn : Button

    private val maxNumbers = 10
    private val numberArray = IntArray(maxNumbers)
    private var numberCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats_functions)

        statNumber = findViewById(R.id.statNumber)
        addBtn = findViewById(R.id.addBtn)
        memNumbers = findViewById(R.id.memNumbers)
        textView6 = findViewById(R.id.textView6)
        clearBtn = findViewById(R.id.clearBtn)
        avgBtn = findViewById(R.id.avgBtn)
        minmaxBtn = findViewById(R.id.minmaxBtn)

        val backBtn = findViewById<Button>(R.id.backBtn)

        backBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        addBtn.setOnClickListener {
            val enteredNumber = statNumber.text.toString()
            if (numberCount < maxNumbers) {
                if (enteredNumber.isNotEmpty()) {
                    val number = enteredNumber.toInt()
                    numberArray[numberCount] = number
                    numberCount++
                    updateNumbersTextView()
                    statNumber.text
                }
            }
            handleClearBtn()
        }

        clearBtn.setOnClickListener {
            handleClearBtn()
            numberArray.fill(0)
            numberCount = 0
            updateNumbersTextView()
            textView6.text = ""
            statNumber.text
        }

        avgBtn.setOnClickListener {
            if (numberCount > 0) {
                val average = numberArray.take(numberCount).average()
                textView6.text = "Average: $average"
            }else{
                memNumbers.text = "No numbers entered"
            }
        }

    }

    private fun clear() {
        TODO("Not yet implemented")
    }

    private fun updateNumbersTextView() {
        TODO("Not yet implemented")
    }

    private fun handleClearBtn() {

    }
}