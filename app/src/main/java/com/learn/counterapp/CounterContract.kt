package com.learn.counterapp

class CounterContract {
    interface View {
        fun showText(counter: Int)
    }

    interface Model {
        fun increment()
        fun decrement()
        fun getCounter(): Int
    }

    interface Presenter {
        fun attach(view: View)
        fun detach()
        fun onIncrementClick()
        fun onDecrementClick()
    }
}