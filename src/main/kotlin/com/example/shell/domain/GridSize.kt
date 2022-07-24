package com.example.shell.domain

data class GridSize(val width: Int, val height: Int) {
    fun isPointInsideTheGrid(x: Int, y: Int) = (x in 0..width) && (y in 0..height)
    override fun toString() = "GridSize: ($width, $height)"
}
