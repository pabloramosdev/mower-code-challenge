package com.example.shell.infrastructure.adapter.file

import com.example.shell.domain.Movement
import com.example.shell.domain.Mower
import com.example.shell.domain.port.FileReader
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.nio.file.Path

internal class MowerFileReaderTest {

    private lateinit var path: Path

    private lateinit var fileReader: FileReader

    @BeforeEach
    fun setUp() {
        path = Path.of("", "src/test/resources/mowers.txt")
        fileReader = MowerFileReader()
    }

    @Test
    fun parseFile() {
        val result = fileReader.parseFile("src/test/resources/mowers.txt")
        val gridSize = result.gridSize
        val instructions: Map<Mower, List<Movement>> = result.instructions
        assertEquals(5, gridSize.width)
        assertEquals(5, gridSize.height)
        assertTrue(instructions.size==2)
    }
}