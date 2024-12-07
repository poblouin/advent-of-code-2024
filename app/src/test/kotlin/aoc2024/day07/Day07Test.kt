package aoc2024.day07

import aoc2024.utils.FileLoader
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.io.File

class Day07Test :
    FileLoader(
        "07",
        part1 = listOf(3749L, 12839601725877L),
        part2 = listOf(11387L, 149956401519484L),
    ) {
    lateinit var solution: Day07

    @BeforeEach
    fun setUp() {
        solution = Day07()
    }

    @ParameterizedTest
    @MethodSource("argumentsPart1")
    fun part1(
        file: File,
        result: Any,
    ) {
        solution.part1(file.readLines()) shouldBe result
    }

    @ParameterizedTest
    @MethodSource("argumentsPart2")
    fun part2(
        file: File,
        result: Any,
    ) {
        solution.part2(file.readLines()) shouldBe result
    }
}
