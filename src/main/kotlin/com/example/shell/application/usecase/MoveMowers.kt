package com.example.shell.application.usecase

import com.example.shell.domain.GridSize
import com.example.shell.domain.Movement
import com.example.shell.domain.Mower
import com.example.shell.domain.MowerMovements
import org.springframework.stereotype.Component

@Component
class MoveMowers {

    fun moveMowers(mowerMovements: MowerMovements): List<Mower> {
        val grid = mowerMovements.gridSize
        val mowerSet = mowerMovements.instructions.keys
        for (entry in mowerMovements.instructions) {
            val mower = entry.key
            val instructions = entry.value
            for (movement in instructions) {
                doMovement(mower, movement)
                checkIfMowerIsInsideTheGrid(grid, mower.finalX, mower.finalY)
                checkIfMowerCollidedWithOther(mowerSet, mower)
            }
        }
        return mowerSet.toList()
    }

    private fun checkIfMowerCollidedWithOther(mowerSet: Set<Mower>, mower: Mower) {
        if (mowerSet.count { it != mower && mower.collideWith(it) } > 0) {
            throw Exception("Mower $mower.id has collided at Position (${mower.finalX}, ${mower.finalY})")
        }
    }

    private fun checkIfMowerIsInsideTheGrid(grid: GridSize, x: Int, y: Int) {
        if (!grid.isPointInsideTheGrid(x, y)) {
            throw Exception("Mower is out the grid")
        }
    }

    private fun doMovement(mower: Mower, movement: Movement) {
        when(movement) {
            Movement.L -> mower.turnOnLeft()
            Movement.R -> mower.turnOnRight()
            Movement.M -> mower.move()
        }
    }

}