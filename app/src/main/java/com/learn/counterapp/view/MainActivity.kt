package com.learn.counterapp.view

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.learn.counterapp.CounterContract
import com.learn.counterapp.R
import com.learn.counterapp.presenter.PresenterFactory

class MainActivity : AppCompatActivity(), CounterContract.View {


    private lateinit var presenter: CounterContract.Presenter

    // Views
    private val tvCounter by lazy { findViewById<TextView>(R.id.tvCounter) }
    private val btIncrement by lazy { findViewById<Button>(R.id.btIncrement) }
    private val btDecrement by lazy { findViewById<Button>(R.id.btDecrement) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        presenter = PresenterFactory.provide()
        presenter.attach(this)

        btIncrement.setOnClickListener {
            presenter.onIncrementClick()
        }

        btDecrement.setOnClickListener {
            presenter.onDecrementClick()
        }
    }

    override fun showText(counter: Int) {
        tvCounter.text = counter.toString()
    }

    override fun onDestroy() {
        presenter.detach()
        super.onDestroy()
    }
}