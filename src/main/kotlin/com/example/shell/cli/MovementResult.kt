package com.example.shell.cli

import com.example.shell.domain.Orientation
import java.util.UUID

data class MovementResult(val id: UUID, val initialX: Int, val initialY: Int, val initialOrientation: Orientation,
                          val finalX: Int, val finalY: Int, val finalOrientation: Orientation
) {
    override fun toString() = "\nMower $id --> " +
                "InitialPosition: ($initialX, $initialY) Orientation: $initialOrientation - " +
                "FinalPosition: ($finalX, $finalY) Orientation: $finalOrientation"
}