package com.example.shell.domain

import com.example.shell.domain.Orientation.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.*

internal class MowerTest {

    private val mower = Mower(UUID.randomUUID(), 1,1, N,1,1, N)

    @Test
    fun turnOnRight() {
        mower.turnOnRight()
        assertEquals(1, mower.finalX)
        assertEquals(1, mower.finalY)
        assertEquals(E, mower.finalOrientation)
    }

    @Test
    fun turnOnLeft() {
        mower.turnOnLeft()
        assertEquals(1, mower.finalX)
        assertEquals(1, mower.finalY)
        assertEquals(W, mower.finalOrientation)
    }

    @Test
    fun move() {
        mower.move()
        assertEquals(1, mower.finalX)
        assertEquals(2, mower.finalY)
        assertEquals(N, mower.finalOrientation)
    }

    @Test
    fun collideWith() {
        val mowerInTheMiddle = Mower(UUID.randomUUID(), 1,1, W,1,1, W)
        assertTrue(mower.collideWith(mowerInTheMiddle))
    }
}