package com.learn.counterapp.view

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.learn.counterapp.R
import com.learn.counterapp.controller.CounterController
import com.learn.counterapp.controller.CounterControllerImpl
import com.learn.counterapp.model.CounterModel
import com.learn.counterapp.model.CounterModelImpl

class MainActivity : AppCompatActivity(), CounterView {

    // Model
    private val model: CounterModel by lazy { CounterModelImpl() }

    // Controller
    private val controller: CounterController by lazy {
        CounterControllerImpl(
            model,
            this
        )
    }

    // Views
    private val tvCounter by lazy { findViewById<TextView>(R.id.tvCounter) }
    private val btIncrement by lazy { findViewById<Button>(R.id.btIncrement) }
    private val btDecrement by lazy { findViewById<Button>(R.id.btDecrement) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btIncrement.setOnClickListener {
            controller.onIncrementClick()
        }

        btDecrement.setOnClickListener {
            controller.onDecrementClick()
        }
    }

    override fun showText(counter: Int) {
        tvCounter.text = counter.toString()
    }
}