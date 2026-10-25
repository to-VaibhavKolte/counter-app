package com.learn.counterapp.model

interface CounterModel {
    fun increment()
    fun decrement()
    fun getCounter(): Int
}