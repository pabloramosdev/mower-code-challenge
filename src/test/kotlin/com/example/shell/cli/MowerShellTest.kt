package com.example.shell.cli

import com.example.shell.application.MowerMovementHandler
import com.example.shell.domain.Movement
import com.example.shell.domain.Mower
import com.example.shell.domain.Orientation
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.shell.Input
import org.springframework.shell.Shell
import java.nio.file.Paths


@SpringBootTest(properties = ["spring.shell.interactive.enabled=false"])
internal class MowerShellTest {

    @Autowired
    private val shell: Shell? = null

    @Autowired
    private lateinit var mowerMovementHandler: MowerMovementHandler

    @Suppress("UNCHECKED_CAST")
    @Test
    fun start() {
        val res = shell?.evaluate { "start --f "
            .plus(Paths.get("src", "test","resources","mowers.txt")) } as List<MovementResult>

        assertTrue(res.size==2)

        val movementResult1 = res[0]
        val movementResult2 = res[1]

        assertEquals(1, movementResult1.initialX)
        assertEquals(2, movementResult1.initialY)
        assertEquals(Orientation.N, movementResult1.initialOrientation)
        assertEquals(1, movementResult1.finalX)
        assertEquals(3, movementResult1.finalY)
        assertEquals(Orientation.N, movementResult1.finalOrientation)

        assertEquals(3, movementResult2.initialX)
        assertEquals(3, movementResult2.initialY)
        assertEquals(Orientation.E, movementResult2.initialOrientation)
        assertEquals(5, movementResult2.finalX)
        assertEquals(1, movementResult2.finalY)
        assertEquals(Orientation.E, movementResult2.finalOrientation)    }
}