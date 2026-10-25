package com.learn.counterapp.presenter

import com.learn.counterapp.CounterContract

class PresenterImpl(
    private val model: CounterContract.Model
) : CounterContract.Presenter {
    private var view: CounterContract.View? = null
    override fun attach(view: CounterContract.View) {
        this.view = view
    }

    override fun detach() {
        this.view = null
    }

    override fun onIncrementClick() {
        model.increment()
        view?.showText(model.getCounter())
    }

    override fun onDecrementClick() {
        model.decrement()
        view?.showText(model.getCounter())
    }
}