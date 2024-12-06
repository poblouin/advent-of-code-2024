package aoc2024.day06

import aoc2024.utils.FileLoader
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.io.File

class Day06Test :
    FileLoader(
        "06",
        part1 = listOf(41, 4758),
        part2 = listOf(0, 0),
    ) {
    lateinit var solution: Day06

    @BeforeEach
    fun setUp() {
        solution = Day06()
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
