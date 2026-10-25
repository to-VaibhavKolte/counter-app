package com.learn.counterapp.presenter

import com.learn.counterapp.model.CounterModelImpl

object PresenterFactory {
    fun provide() = PresenterImpl(CounterModelImpl())
}