package com.learn.counterapp

import com.learn.counterapp.controller.CounterControllerImpl
import com.learn.counterapp.model.CounterModel
import com.learn.counterapp.view.CounterView
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class CounterControllerImplTest {

    private lateinit var model: CounterModel
    private lateinit var view: CounterView
    private lateinit var controller: CounterControllerImpl

    @Before
    fun setUp() {
        model = mockk(relaxed = true)
        view = mockk(relaxed = true)

        controller = CounterControllerImpl(model, view)
    }

    @Test
    fun `onIncrementClick should increment counter and update view`() {
        // Arrange
        every { model.getCounter() } returns 1

        // Act
        controller.onIncrementClick()

        // Assert
        verify(exactly = 1) {
            model.increment()
        }

        verify(exactly = 1) {
            model.getCounter()
        }

        verify(exactly = 1) {
            view.showText(1)
        }
    }

    @Test
    fun `onDecrementClick should decrement counter and update view`() {
        // Arrange
        every { model.getCounter() } returns 0

        // Act
        controller.onDecrementClick()

        // Assert
        verify(exactly = 1) {
            model.decrement()
        }

        verify(exactly = 1) {
            model.getCounter()
        }

        verify(exactly = 1) {
            view.showText(0)
        }
    }
}