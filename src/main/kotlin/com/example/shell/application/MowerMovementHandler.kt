package com.example.shell.application

import com.example.shell.application.usecase.MoveMowers
import com.example.shell.cli.MovementResult
import com.example.shell.domain.port.FileReader
import org.springframework.stereotype.Component

@Component
class MowerMovementHandler(private val fileReader: FileReader, private val moveMowers: MoveMowers) {
    fun handle(fileName: String) : List<MovementResult> {
        val mowerMovements = fileReader.parseFile(fileName)
        val mowerList = moveMowers.moveMowers(mowerMovements)
        return mowerList.map { mower ->
            MovementResult(mower.id, mower.initialX, mower.initialY, mower.initialOrientation, mower.finalX, mower.finalY, mower.finalOrientation) }
    }
}