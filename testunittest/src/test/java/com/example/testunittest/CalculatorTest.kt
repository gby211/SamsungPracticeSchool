package com.example.testunittest

import org.junit.After
import org.junit.Assert
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class CalculatorTest {
    private var calculator: Calculator? = null
    @Before
    fun setUp() {
        calculator = Calculator()
    }

    @Test
    fun addition() {
        Assert.assertEquals(3, calculator!!.add(1, 2).toLong())
    }

    @Test(expected = NullPointerException::class)
    fun nullStringTest() {
        val str: String? = null
        assertTrue(str!!.isEmpty())
    }

    @After
    fun tearDown() {
        calculator = null
    }
}