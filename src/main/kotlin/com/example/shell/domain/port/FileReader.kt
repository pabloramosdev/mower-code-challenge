package com.example.shell.domain.port

import com.example.shell.domain.MowerMovements

interface FileReader {

    fun parseFile(name: String): MowerMovements

}