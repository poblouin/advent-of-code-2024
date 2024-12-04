package aoc2024.day04

import aoc2024.utils.FileLoader
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.io.File

class Day04Test :
    FileLoader(
        "04",
        part1 = listOf(18, 2575),
        part2 = listOf(9, 2041),
    ) {
    lateinit var solution: Day04

    @BeforeEach
    fun setUp() {
        solution = Day04()
    }

    @ParameterizedTest
    @MethodSource("argumentsPart1")
    fun part1(
        file: File,
        result: Int,
    ) {
        solution.part1(file.readText()) shouldBe result
    }

    @ParameterizedTest
    @MethodSource("argumentsPart2")
    fun part2(
        file: File,
        result: Int,
    ) {
        solution.part2(file.readText()) shouldBe result
    }
}
