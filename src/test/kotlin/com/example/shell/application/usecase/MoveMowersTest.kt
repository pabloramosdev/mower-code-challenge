package com.example.shell.application.usecase

import com.example.shell.domain.*
import com.example.shell.domain.Movement.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.assertThrows
import java.util.*

internal class MoveMowersTest {

    private lateinit var moveMowers : MoveMowers

    private val mowerOne =   Mower(UUID.randomUUID(), 1,1, Orientation.N,1,1, Orientation.N)
    private val mowerTwo =   Mower(UUID.randomUUID(), 1,2, Orientation.N,1,2, Orientation.N)
    private val theOutsider = Mower(UUID.randomUUID(), 1,4, Orientation.W,1,4, Orientation.W)
    private val mowerThree = Mower(UUID.randomUUID(), 3,3, Orientation.E,3,3, Orientation.E)

    private val mowerMovementsCollision = MowerMovements(GridSize(5,5), mapOf(Pair(mowerOne, listOf(M)), Pair(mowerTwo, listOf(L))))
    private val outsiderMowerMovements = MowerMovements(GridSize(5,5), mapOf(Pair(theOutsider, listOf(M,M))))
    private val mowerMovementsSuccess = MowerMovements(GridSize(5,5),
        mapOf(Pair(mowerTwo, listOf(L,M,L,M,L,M,L,M,M)), Pair(mowerThree, listOf(M,M,R,M,M,R,M,R,R,M))))

    @BeforeEach
    fun setUp() {
        moveMowers = MoveMowers()
    }

    @Test
    fun `should return result when all mowers complete the movements`() {
        val result = moveMowers.moveMowers(mowerMovementsSuccess)

        assertTrue(result.size == 2)
        val mower1 = result[0]
        val mower3 = result[1]

        assertEquals(1, mower1.finalX)
        assertEquals(3, mower1.finalY)
        assertEquals(Orientation.N, mower1.finalOrientation)

        assertEquals(5, mower3.finalX)
        assertEquals(1, mower3.finalY)
        assertEquals(Orientation.E, mower3.finalOrientation)
    }

    @Test
    fun `should throw exception when mowers collide`() {
        assertThrows<Exception> {
            moveMowers.moveMowers(mowerMovementsCollision) }
        }

    @Test
    fun `should throw exception when mower is outside the grid`() {
        assertThrows<Exception> {
            moveMowers.moveMowers(outsiderMowerMovements) }
    }
}