package com.example.geoquiz

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
private const val TAG ="MainActivity"
class MainActivity : AppCompatActivity() {
    private lateinit var trueButton:Button
    private lateinit var falseButton:Button
    private lateinit var questionText:TextView
    private lateinit var nextButton:ImageView
    private lateinit var previousButton:ImageView

    private val questionBank = listOf(
        Question(R.string.question_australia,true),
        Question(R.string.question_africa,false),
        Question(R.string.question_ukraine,true),
    )
    private var currentIndex =0



    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate called")
        setContentView(R.layout.activity_main)
        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        questionText = findViewById(R.id.question_text_view)
        nextButton = findViewById(R.id.next_button)
        previousButton = findViewById(R.id.previous_button)
        trueButton.setOnClickListener {
        checkAnswer(true)
//            Toast.makeText(this,R.string.correct_toast,Toast.LENGTH_LONG).show()
        }
        falseButton.setOnClickListener {
            checkAnswer(false)
//            Toast.makeText(this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show()
        }

        nextButton.setOnClickListener{
            currentIndex= (currentIndex+1)%questionBank.size
            updateQuestion()
        }

        previousButton.setOnClickListener{
            currentIndex= (currentIndex+questionBank.size-1)%questionBank.size
            updateQuestion()
        }
        updateQuestion()


    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart called")
    }

    override fun onResume() {
        Log.d(TAG,"onResume called")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG,"onPause called")

        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG,"onStop called")

        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG,"onDestroy called")

        super.onDestroy()
    }






    private fun checkAnswer(b: Boolean) {

        val correct_answer = questionBank[currentIndex].answer
        val messageResId= if(correct_answer == b){
            R.string.correct_toast
        }else{
            R.string.incorrect_toast

        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }

    private fun updateQuestion() {
        questionText.setText(questionBank[currentIndex].textResId)
    }

}