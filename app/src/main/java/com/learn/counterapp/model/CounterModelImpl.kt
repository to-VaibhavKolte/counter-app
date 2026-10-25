package com.learn.counterapp.model

class CounterModelImpl : CounterModel {

    private var counter = 0
    override fun increment() {
        counter++
    }

    override fun decrement() {
        counter--
    }

    override fun getCounter(): Int = counter
}