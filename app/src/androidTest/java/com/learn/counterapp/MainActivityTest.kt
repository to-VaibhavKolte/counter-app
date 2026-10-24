package com.learn.counterapp
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun counter_displaysZero_whenAppLaunches() {
        onView(withId(R.id.tvCounter))
            .check(matches(withText("0")))
    }

    @Test
    fun counter_increments_whenIncrementButtonClicked() {
        onView(withId(R.id.btIncrement))
            .perform(click())

        onView(withId(R.id.tvCounter))
            .check(matches(withText("1")))
    }

    @Test
    fun counter_incrementsMultipleTimes() {
        repeat(3) {
            onView(withId(R.id.btIncrement))
                .perform(click())
        }

        onView(withId(R.id.tvCounter))
            .check(matches(withText("3")))
    }

    @Test
    fun counter_decrements_whenDecrementButtonClicked() {
        onView(withId(R.id.btIncrement))
            .perform(click())

        onView(withId(R.id.btDecrement))
            .perform(click())

        onView(withId(R.id.tvCounter))
            .check(matches(withText("0")))
    }

    @Test
    fun counter_canBecomeNegative_withCurrentImplementation() {
        onView(withId(R.id.btDecrement))
            .perform(click())

        onView(withId(R.id.tvCounter))
            .check(matches(withText("-1")))
    }
}