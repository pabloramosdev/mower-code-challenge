package com.example.shell.application

import com.example.shell.application.usecase.MoveMowers
import com.example.shell.domain.GridSize
import com.example.shell.domain.Movement
import com.example.shell.domain.Mower
import com.example.shell.domain.MowerMovements
import com.example.shell.domain.port.FileReader
import com.example.shell.infrastructure.adapter.file.MowerFileReader
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.Mockito.*

internal class MowerMovementHandlerTest {

    private lateinit var fileReader: FileReader
    private lateinit var moveMowers: MoveMowers
    private lateinit var mowerMovementHandler: MowerMovementHandler

    @BeforeEach
    fun setUp() {
        moveMowers = mock(MoveMowers::class.java)
        fileReader = mock(MowerFileReader::class.java)
        mowerMovementHandler = MowerMovementHandler(fileReader, moveMowers)
    }

    @Test
    fun handle() {
        val mowerMovements = MowerMovements(GridSize(5,5), emptyMap<Mower, List<Movement>>())
        `when`(fileReader.parseFile(anyString())).thenReturn(mowerMovements)
        `when`(moveMowers.moveMowers(mowerMovements)).thenReturn(emptyList())
        val results = mowerMovementHandler.handle("/path/to/the/file")
        assertNotNull(results)
        assertTrue(results.isEmpty())
    }
}