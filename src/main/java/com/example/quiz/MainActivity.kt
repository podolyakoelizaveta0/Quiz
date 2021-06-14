package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import android.util.Log

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: ImageButton
    private lateinit var prevButton: ImageButton
    private lateinit var questionTextView:
            TextView
    private val questionBank = listOf(
            Question(R.string.question_ram1, true),
            Question(R.string.question_ram2,
                    false),
            Question(R.string.question_ram3,
                    false),
            Question(R.string.question_ram4,
                    true),
            Question(R.string.question_ram5
                    , true),
            Question(R.string.question_ram6,
                    false) ,
            Question(R.string.question_ram7,
            true),
            Question(R.string.question_ram8,
                    false),
            Question(R.string.question_ram9,
                    true),
            Question(R.string.question_ram10,
                    true)
    )
    private var currentIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,
                "onCreate(Bundle?) called")

        setContentView(R.layout.activity_main)
        trueButton =
                findViewById(R.id.true_button)
        falseButton =
                findViewById(R.id.false_button)
        nextButton =
                findViewById(R.id.next_button)
        prevButton =
                findViewById(R.id.prev_button)
        questionTextView =
                findViewById(R.id.question_text_view)


        trueButton.setOnClickListener { view: View ->
            checkAnswer(true)
        }
        falseButton.setOnClickListener { view: View ->

            checkAnswer(false)
        }

        prevButton.setOnClickListener {

                currentIndex -= 1
            updateQuestion()
        }

        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) %
                    questionBank.size
            updateQuestion()
        }

        questionTextView.setOnClickListener {
            currentIndex = (currentIndex + 1) %
                    questionBank.size
            updateQuestion()
        }



        updateQuestion()


    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,
                "onStart() called")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG,
                "onResume() called")
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG,
                "onPause() called")
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG,
                "onStop() called")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,
                "onDestroy() called")
    }

    private fun updateQuestion() {
        val questionTextResId =
                questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer:
                            Boolean) {
        val correctAnswer =
                questionBank[currentIndex].answer
        val messageResId = if (userAnswer ==
                correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }
        Toast.makeText(this, messageResId,
                Toast.LENGTH_SHORT)
                .show()
    }

}