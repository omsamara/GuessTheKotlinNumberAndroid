package com.example.osamara.guessthekotlinnumber

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.Random



class MainActivity : AppCompatActivity() {

    lateinit var text: TextView
    lateinit var guessText: EditText
    lateinit var guessedNumbersText: TextView
    lateinit var resetButton: Button
    lateinit var submitButton: Button
    var randomNum: Int = -1
    var playerGuess: Int = -1
    var attempts: Int = 1
    val RANDOM = Random()
    lateinit var guessedNumbers: ArrayList<Int>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text = findViewById(R.id.titleView) as TextView
        guessText = findViewById(R.id.enterGuess) as EditText
        resetButton = findViewById(R.id.resetButton) as Button
        guessedNumbers = ArrayList<Int>()
        guessedNumbersText = findViewById(R.id.guessedNumbers) as TextView
        genRandomNum()
        50
    }

    fun genRandomNum() {
        randomNum = RANDOM.nextInt(100) + 1
    }

    fun submittedGuess(view: View) {


        if (guessText.text.isEmpty()) {
            Toast.makeText(this, "You have to enter a guess!", Toast.LENGTH_SHORT).show()

        }
        else {

            playerGuess = guessText.text.toString().toInt()

            guessedNumbers.add(playerGuess)
            guessedNumbersText.setText("Guessed Numbers: " + guessedNumbers.toString())
            if (playerGuess < randomNum)
                Toast.makeText(this, "Your guess is lower than the magic number", Toast.LENGTH_SHORT).show()

            else if (playerGuess > randomNum)

                Toast.makeText(this, "Your guess is higher than the magic number", Toast.LENGTH_SHORT).show()
            else {

                text.setText("Congratulations! You've guessed the magic number after " + guessedNumbers.size + " tries!")
                Toast.makeText(this, "Nice job! press the reset game button to play again", Toast.LENGTH_SHORT).show()
            }

            guessText.text.clear()

        }

    }

    fun resetGame(view: View) {
        text.setText("Guess The Magic Number!")
        guessedNumbersText.setText("Guessed Numbers: ")
        playerGuess = -1
        guessedNumbers.clear()
        genRandomNum()
        Toast.makeText(this, "New number generated", Toast.LENGTH_SHORT).show()

    }
}
