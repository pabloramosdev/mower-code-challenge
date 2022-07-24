package com.example.shell.domain

import com.example.shell.domain.Orientation.*
import java.util.UUID

class Mower(val id: UUID, val initialX: Int, val initialY: Int, val initialOrientation: Orientation,
            var finalX: Int, var finalY: Int, var finalOrientation: Orientation) {

    fun turnOnRight() {
        finalOrientation = when(finalOrientation) {
            N -> E
            E -> S
            S -> W
            W -> N
        }
    }

    fun turnOnLeft() {
        finalOrientation = when(finalOrientation) {
            N -> W
            W -> S
            S -> E
            E -> N
        }
    }

    fun move() {
        when(finalOrientation) {
            N -> ++finalY
            S -> --finalY
            E -> ++finalX
            W -> --finalX
        }
    }

    fun collideWith(other: Mower) : Boolean = other.finalX == this.finalX && other.finalY == this.finalY

}