package vcmsa.ci.historyapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var ageDisplay: EditText
    private lateinit var ageBtn: Button
    private lateinit var clearBtn: Button
    private lateinit var searchResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ageDisplay = findViewById(R.id.ageDisplay)
        ageBtn = findViewById(R.id.ageBtn)
        clearBtn = findViewById(R.id.clearBtn)
        searchResult = findViewById(R.id.searchResult)

        ageBtn.setOnClickListener {
            handleAgeBtnClick()
        }

        clearBtn.setOnClickListener {
            handleClearBtnClick()
        }

    }

    private fun handleAgeBtnClick() {
        val ageInput = ageDisplay.text.toString()
        if (ageInput.isEmpty()) {
            searchResult.text = "Please enter your age."
            return
        }
        val age = ageInput.toUIntOrNull()
        if (age == null) {
            searchResult.text = "The age entered is invalid. Please enter a valid whole number."
            return
        }
        if (age < 20u || age > 100u) {
            searchResult.text = "The age entered is out of range. Please enter an age between 20 and 100."
            return
        }
        val matchedPerson = matchAgeToHistoricalFigure(age)
        searchResult.text= matchedPerson
    }

    private fun matchAgeToHistoricalFigure(age: UInt?): String {
        val historicalFigures = mapOf(
            "King Baldwin IV" to 24,
            "Adolf Hitler" to 56,
            "Issac Newton" to 84,
            "Joseph Stalin" to 74,
            // add more historical figures
        )

        for ((person, personAge) in historicalFigures) {
            if (age?.toInt() == personAge) {
                return "You share the same age with $person when they passed away."
            }
        }
        return "No historical fure found in the datatbase with the same age as you."
    }

    private fun handleClearBtnClick() {
        ageDisplay.text.clear()
        searchResult.text = ""
    }
}