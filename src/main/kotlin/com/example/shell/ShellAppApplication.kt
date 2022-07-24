package com.example.shell

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ShellAppApplication

fun main(args: Array<String>) {
	runApplication<ShellAppApplication>(*args)
}
