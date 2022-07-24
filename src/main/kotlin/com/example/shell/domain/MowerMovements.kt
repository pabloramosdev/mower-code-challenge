package com.example.shell.domain

data class MowerMovements(val gridSize: GridSize, val instructions: Map<Mower, List<Movement>>) {
    init {
        val mowerSet = instructions.keys
        mowerSet.forEach {
                mower -> if (!gridSize.isPointInsideTheGrid(mower.initialX, mower.initialY))
                    throw Exception("Invalid initial position (${mower.initialX}, ${mower.initialY}) ")
        }
    }
}