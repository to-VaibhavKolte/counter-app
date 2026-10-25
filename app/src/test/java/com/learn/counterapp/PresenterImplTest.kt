package com.learn.counterapp

import com.learn.counterapp.presenter.PresenterImpl
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test


class PresenterImplTest {

    private lateinit var model: CounterContract.Model
    private lateinit var view: CounterContract.View
    private lateinit var presenter: PresenterImpl

    @Before
    fun setUp() {
        model = mockk(relaxed = true)
        view = mockk(relaxed = true)

        presenter = PresenterImpl(model)
    }

    @Test
    fun `attach should allow view to receive counter text`() {
        // Arrange
        every { model.getCounter() } returns 5
        presenter.attach(view)

        // Act
        presenter.onIncrementClick()

        // Assert
        verify(exactly = 1) { view.showText(5) }
    }

    @Test
    fun `increment click should increment model and update view`() {
        // Arrange
        every { model.getCounter() } returns 1
        presenter.attach(view)

        // Act
        presenter.onIncrementClick()

        // Assert
        verify(exactly = 1) { model.increment() }
        verify(exactly = 1) { model.getCounter() }
        verify(exactly = 1) { view.showText(1) }
    }

    @Test
    fun `decrement click should decrement model and update view`() {
        // Arrange
        every { model.getCounter() } returns 0
        presenter.attach(view)

        // Act
        presenter.onDecrementClick()

        // Assert
        verify(exactly = 1) { model.decrement() }
        verify(exactly = 1) { model.getCounter() }
        verify(exactly = 1) { view.showText(0) }
    }

    @Test
    fun `detach should prevent view updates`() {
        // Arrange
        presenter.attach(view)
        presenter.detach()
        every { model.getCounter() } returns 1

        // Act
        presenter.onIncrementClick()

        // Assert
        verify(exactly = 1) { model.increment() }
        verify(exactly = 0) { view.showText(any()) }
    }

    @Test
    fun `increment without attached view should not throw exception`() {
        // Arrange
        every { model.getCounter() } returns 1

        // Act and Assert
            presenter.onIncrementClick()
    }

    @Test
    fun `decrement without attached view should not throw exception`() {
        // Arrange
        every { model.getCounter() } returns 0

        // Act and Assert
            presenter.onDecrementClick()
    }
}
