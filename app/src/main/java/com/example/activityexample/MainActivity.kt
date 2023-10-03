package com.example.activityexample

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import org.w3c.dom.Text

const val MESSAGE_KEY = "message"
const val RESULT_KEY = "reply_message"
class MainActivity : AppCompatActivity() {

    lateinit var resultTextView : TextView

    val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if (it.resultCode == RESULT_OK)
            it.data?.apply {
                resultTextView.text = getStringExtra(RESULT_KEY)

            }

    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        resultTextView = findViewById<TextView>(R.id.resultTextView)

        findViewById<Button>(R.id.launchButton).setOnClickListener {
            val launchIntent = Intent(this@MainActivity, SecondActivity::class.java)
            launchIntent.putExtra(MESSAGE_KEY, "Hello! this is a message to SecondActivity")
            launcher.launch(launchIntent)
        }
    }
}