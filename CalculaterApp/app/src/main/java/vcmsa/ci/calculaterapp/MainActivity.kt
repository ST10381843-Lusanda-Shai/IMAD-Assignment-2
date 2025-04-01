
package vcmsa.ci.calculaterapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var number1: TextView? = null
    private var number2: TextView? = null
    private var answer: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        number1 = findViewById(R.id.number1)
        number2 = findViewById(R.id.number2)
        answer = findViewById(R.id.answer)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSub = findViewById<Button>(R.id.btnSub)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnDiv = findViewById<Button>(R.id.btnDiv)
        val btnSquareRoot = findViewById<Button>(R.id.btnSquareRoot)
        val btnPower = findViewById<Button>(R.id.btnPower)
        val btnStats = findViewById<Button>(R.id.btnStats)

        btnAdd.setOnClickListener()
        {
            add()
        }
        btnSub.setOnClickListener {
            subtract()
        }
        btnMultiply.setOnClickListener {
            multiply()
        }
        btnDiv.setOnClickListener {
            divide()
        }


        btnStats.setOnClickListener {
            val intent = Intent(this, StatsFunctions::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun add() {
        if (inputIsNotempty()) {
            val input1 = number1?.text.toString().trim().toBigDecimal()
            val input2 = number2?.text.toString().trim().toBigDecimal()
            answer?.text = input1.add(input2).toString()
        }
    }

    private fun subtract() {
        if (inputIsNotempty()) {
            val input1 = number1?.text.toString().trim().toBigDecimal()
            val input2 = number2?.text.toString().trim().toBigDecimal()
            answer?.text = input1.subtract(input2).toString()
        }
    }

    private fun multiply() {
        if (inputIsNotempty()) {
            val input1 = number1?.text.toString().trim().toBigDecimal()
            val input2 = number2?.text.toString().trim().toBigDecimal()
            answer?.text = input1.multiply(input2).toString()
        }
    }

    private fun divide() {
        if (inputIsNotempty()) {
            val input1 = number1?.text.toString().trim().toBigDecimal()
            val input2 = number2?.text.toString().trim().toBigDecimal()
            answer?.text = input1.divide(input2).toString()
        }
    }

    private fun inputIsNotempty(): Boolean {
        var b = true
        if (number1?.text.toString().trim().isEmpty()) {
            number1?.error = "Required"
        }
        if (number2?.text.toString().trim().isEmpty()) {
            number2?.error = "Required"
        }
        return b
    }

}