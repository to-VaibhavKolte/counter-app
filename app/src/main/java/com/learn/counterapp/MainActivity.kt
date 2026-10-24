package com.learn.counterapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // Counter
    private var count = 0

    // Views
    private val tvCounter by lazy { findViewById<TextView>(R.id.tvCounter) }
    private val btIncrement by lazy { findViewById<Button>(R.id.btIncrement) }
    private val btDecrement by lazy { findViewById<Button>(R.id.btDecrement) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btIncrement.setOnClickListener {
            count++
            showCounter()
        }

        btDecrement.setOnClickListener {
            count--
            showCounter()
        }
    }

    private fun showCounter(){
        tvCounter.text = count.toString()
    }
}