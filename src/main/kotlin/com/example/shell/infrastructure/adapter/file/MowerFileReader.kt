package com.example.shell.infrastructure.adapter.file

import com.example.shell.domain.MowerMovements
import com.example.shell.domain.*
import com.example.shell.domain.port.FileReader
import org.springframework.stereotype.Component
import java.io.File
import java.util.*

@Component
class MowerFileReader : FileReader {

    private val mowerPositionRegex = Regex("\\d{1,2}\\s\\d{1,2}\\s[NSEW]")
    private val mowerInstructionsRegex = Regex("[LRM]{1,10}")
    private val gridSizeRegex = Regex("\\d{1,2}\\s\\d{1,2}")

    override fun parseFile(name: String): MowerMovements {
        val file = File(name)

        if (!file.exists()) {
            throw Exception("Error, file does not exists")
        }

        val bufferedReader = file.bufferedReader()
        val header = bufferedReader.readLine()
        val tokenList = bufferedReader.readLines()

        val gridSize = parseHeader(header)
        val mowerMovements = parseTokenList(tokenList)

        return MowerMovements(gridSize, mowerMovements)
    }

    private fun parseHeader(header: String): GridSize = header.validate(gridSizeRegex).split(String.BLANK)
        .chunked(2) { GridSize(it[0].toInt(), it[1].toInt()) }.first()

    private fun parseTokenList(tokenList: List<String>): Map<Mower, List<Movement>> = tokenList
        .chunked(2) { parseMowerPosition(it[0]) to parseInstructions(it[1]) }.toMap()

    private fun parseMowerPosition(mowerPositionToken: String): Mower = mowerPositionToken.validate(mowerPositionRegex).split(String.BLANK)
        .chunked(3) { Mower(UUID.randomUUID(), it[0].toInt(), it[1].toInt(), Orientation.valueOf(it[2]),
            it[0].toInt(), it[1].toInt(), Orientation.valueOf(it[2])) }.first()

    private fun parseInstructions(instructions: String): List<Movement> = instructions.validate(mowerInstructionsRegex)
        .chunked(1) { Movement.valueOf(it.toString()) }.toList()
}