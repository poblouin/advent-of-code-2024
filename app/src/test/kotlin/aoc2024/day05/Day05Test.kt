package aoc2024.day05

import aoc2024.utils.FileLoader
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.io.File

class Day05Test :
    FileLoader(
        "05",
        part1 = listOf(143, 4959),
        part2 = listOf(123, 4655),
    ) {
    lateinit var solution: Day05

    @BeforeEach
    fun setUp() {
        solution = Day05()
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
