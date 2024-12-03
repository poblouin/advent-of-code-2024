package aoc2024.utils

fun List<String>.toIntList(): List<List<Int>> = map { it.split("\\s+".toRegex()).map { it.toInt() } }
