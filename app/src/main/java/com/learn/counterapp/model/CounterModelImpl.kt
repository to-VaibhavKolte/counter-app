package com.learn.counterapp.model

import com.learn.counterapp.CounterContract

class CounterModelImpl : CounterContract.Model {

    private var counter = 0
    override fun increment() {
        counter++
    }

    override fun decrement() {
        counter--
    }

    override fun getCounter(): Int = counter
}