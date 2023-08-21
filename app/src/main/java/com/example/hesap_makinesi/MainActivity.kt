package com.example.hesap_makinesi
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var input: TextView
    private lateinit var output: TextView

    private lateinit var add: Button
    private lateinit var sub: Button
    private lateinit var mul: Button
    private lateinit var div: Button


    private lateinit var zero: Button
    private lateinit var one: Button
    private lateinit var two: Button
    private lateinit var three: Button
    private lateinit var four: Button
    private lateinit var five: Button
    private lateinit var six: Button
    private lateinit var seven: Button
    private lateinit var eight: Button
    private lateinit var nine: Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView)



        val numberButtons = listOf<Button>(
            findViewById(R.id.btn0),
            findViewById(R.id.btn1),
            findViewById(R.id.btn2),
            findViewById(R.id.btn3),
            findViewById(R.id.btn4),
            findViewById(R.id.btn5),
            findViewById(R.id.btn6),
            findViewById(R.id.btn7),
            findViewById(R.id.btn8),
            findViewById(R.id.btn9)
        )

        val operatorButtons = listOf<Button>(
            findViewById(R.id.add),
            findViewById(R.id.sub),
            findViewById(R.id.mul),
            findViewById(R.id.div)
        )




        var input: String

        zero.setOnClickListener {
            input = addToInputText("0")
        }

        one.setOnClickListener {
            input = addToInputText("1")
        }

        two.setOnClickListener {
            input = addToInputText("2")
        }

        three.setOnClickListener {
            input = addToInputText("3")
        }

        four.setOnClickListener {
            input = addToInputText("4")
        }

        five.setOnClickListener {
            input = addToInputText("5")
        }

        six.setOnClickListener {
            input = addToInputText("6")
        }

        seven.setOnClickListener {
            input = addToInputText("7")
        }

        eight.setOnClickListener {
            input = addToInputText("8")
        }

        nine.setOnClickListener {
            input = addToInputText("9")
        }

        add.setOnClickListener {
            input = addToInputText("+")
        }

        sub.setOnClickListener {
            input = addToInputText("-")
        }

        mul.setOnClickListener {
            input = addToInputText("X")
        }

        div.setOnClickListener {
            input = addToInputText("/")
        }

    }


    private fun addToInputText(str: String): String {
        input.text = "${input.text}$str"
        return input.text.toString()
    }


    private fun getInputExpression(): String {
        var expression = input.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    private fun showResult() {
        val expression = getInputExpression()

        try {
            val result = calculateExpression(expression)
            if (result == null) {
                // Show Error Message
                output.text = "Error"
            } else {
                // Show Result
                output.text = result.toString()
            }
        } catch (e: Exception) {
            // Show Error Message
            output.text = "Error"
        }
    }

    private fun calculateExpression(expression: String): Double? {
        val parts = expression.split(Regex("[+\\-*/]"))
        if (parts.size != 2) {
            return null // Invalid expression
        }

        val operator = expression[parts[0].length]
        val num1 = parts[0].toDoubleOrNull() ?: return null
        val num2 = parts[1].toDoubleOrNull() ?: return null

        return when (operator) {
            '+' -> num1 + num2
            '-' -> num1 - num2
            '*' -> num1 * num2
            '/' -> {
                if (num2 != 0.0) {
                    num1 / num2
                } else {
                    null // Division by zero
                }
            }
            else -> null
        }
    }



}

