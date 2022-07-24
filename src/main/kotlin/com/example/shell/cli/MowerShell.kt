package com.example.shell.cli

import com.example.shell.application.MowerMovementHandler
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod
import org.springframework.shell.standard.ShellOption

@ShellComponent
class MowerShell(private val mowerMovementHandler: MowerMovementHandler) {
    @ShellMethod(value = "Print a message through the console")
    fun start(@ShellOption(value = ["--f"]) file: String): List<MovementResult> {
        return mowerMovementHandler.handle(file)
    }
}