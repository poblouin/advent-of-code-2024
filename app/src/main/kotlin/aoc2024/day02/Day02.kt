package aoc2024.day02

import aoc2024.utils.toIntList
import kotlin.math.absoluteValue

class Day02 {
    fun part1(input: List<String>): Int =
        input
            .toIntList()
            .count { it.isValid() }

    fun part2(input: List<String>): Int =
        input
            .toIntList()
            .count { it.isValid() || it.getAllVariations().any { it.isValid() } }

    fun List<Int>.isValid() = (isAscending() || isDescending()) && hasValidSteps()

    fun List<Int>.isAscending() = windowed(2).all { (a, b) -> a < b }

    fun List<Int>.isDescending() = windowed(2).all { (a, b) -> a > b }

    fun List<Int>.hasValidSteps() = windowed(2).all { (a, b) -> (a - b).absoluteValue in 1..3 }

    fun List<Int>.getAllVariations(): List<List<Int>> =
        indices.fold(emptyList()) { acc, i ->
            acc + listOf(filterIndexed { index, _ -> index != i })
        }
}
