package aoc2024.day01

import aoc2024.utils.toIntList
import kotlin.math.absoluteValue

class Day01 {
    fun part1(input: List<String>): Int = input.splitTwoLists().distance()

    fun part2(input: List<String>): Int = input.splitTwoLists().similarityScore()

    fun List<String>.splitTwoLists() =
        toIntList()
            .map { it[0] to it[1] }
            .unzip()

    fun Pair<List<Int>, List<Int>>.distance(): Int =
        (first.sorted())
            .zip(second.sorted())
            .sumOf { (it.first - it.second).absoluteValue }

    fun Pair<List<Int>, List<Int>>.similarityScore(): Int =
        second.groupingBy { it }.eachCount().let { mapping ->
            first.sumOf { (mapping[it] ?: 0) * it }
        }
}
