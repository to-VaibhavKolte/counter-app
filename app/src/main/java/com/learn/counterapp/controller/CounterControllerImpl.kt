package com.learn.counterapp.controller

import com.learn.counterapp.model.CounterModel
import com.learn.counterapp.view.CounterView

class CounterControllerImpl(
    private val model: CounterModel,
    private val view: CounterView
) : CounterController {
    override fun onIncrementClick() {
        model.increment()
        view.showText(model.getCounter())
    }

    override fun onDecrementClick() {
        model.decrement()
        view.showText(model.getCounter())
    }
}