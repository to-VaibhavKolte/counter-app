package com.learn.counterapp

import com.learn.counterapp.model.CounterModelImpl
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CounterModelImplTest {

    private lateinit var model: CounterModelImpl

    @Before
    fun setUp() {
        model = CounterModelImpl()
    }

    @Test
    fun `initial counter value should be zero`() {
        assertEquals(0, model.getCounter())
    }

    @Test
    fun `increment should increase counter by one`() {
        model.increment()

        assertEquals(1, model.getCounter())
    }

    @Test
    fun `decrement should decrease counter by one`() {
        model.decrement()

        assertEquals(-1, model.getCounter())
    }

    @Test
    fun `multiple increments should increase counter correctly`() {
        model.increment()
        model.increment()
        model.increment()

        assertEquals(3, model.getCounter())
    }

    @Test
    fun `multiple decrements should decrease counter correctly`() {
        model.decrement()
        model.decrement()
        model.decrement()

        assertEquals(-3, model.getCounter())
    }

    @Test
    fun `increment and decrement should cancel each other`() {
        model.increment()
        model.increment()
        model.decrement()

        assertEquals(1, model.getCounter())
    }
}