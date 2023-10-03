package com.example.activityexample

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val message = intent.getStringExtra(MESSAGE_KEY)

        with (findViewById<TextView>(R.id.messageTextView)) {
            text = message
        }

        findViewById<Button>(R.id.closeButton).setOnClickListener() {

            setResult(RESULT_OK, Intent().putExtra(RESULT_KEY, "Here is my result"))


            finish()
        }

    }
}