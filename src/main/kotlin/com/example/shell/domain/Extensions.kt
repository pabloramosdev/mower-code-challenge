package com.example.shell.domain

fun String.validate(regex: Regex): String {
    check(regex matches this) { "invalid value: $this" }
    return this
}

val String.Companion.BLANK: String
    get() = " "