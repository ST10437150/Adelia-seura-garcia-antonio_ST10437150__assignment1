package com.example.historyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editAge = findViewById<EditText>(R.id.editTextNumber)
        val buttonHistory = findViewById<Button>(R.id.buttonHistory)
        val textResult = findViewById<TextView>(R.id.textAnswer)
        val buttonClear = findViewById<Button>(R.id.buttonClear)

        buttonHistory.setOnClickListener {
            val userAgeString = editAge.text.toString()
            val userAge = userAgeString.toIntOrNull()

            val historicalAges = hashMapOf(
                "Leonardo da Vinci" to 67,          // Renaissance polymath, known for Mona Lisa and The Last Supper.
                "Albert Einstein" to 76,            // Theoretical physicist, known for the theory of relativity.
                "William Shakespeare" to 52,        // English playwright and poet, known for works like Romeo and Juliet.
                "Mahatma Gandhi" to 78,             // Leader of the Indian independence movement against British rule.
                "Cleopatra" to 39,                  // Last active ruler of the Ptolemaic Kingdom of Egypt.
                "Nikola Tesla" to 86,               // Inventor and electrical engineer, known for contributions to AC electricity.
                "Pelé" to 25,                       // Brazilian footballer, widely regarded as one of the greatest players of all time.
                "Aristotle" to 62,                  // Greek philosopher, known for his works on logic, ethics, and metaphysics.
                "Galileo Galilei" to 77             // Italian astronomer, physicist, and engineer, known for improvements to the telescope and astronomical observations.
            )


            if (userAge != null) {
                val matchedFigures = historicalAges.filterValues { it == userAge }.keys

                if (matchedFigures.isNotEmpty()) {
                    val result = StringBuilder()
                    result.append("You share the same age as the following historical figures:\n")
                    matchedFigures.forEach { result.append("$it\n") }
                    textResult.text = result.toString()
                }
            }
        }

        buttonClear.setOnClickListener {
            editAge.text.clear()
            textResult.text = ""
        }
    }
}
