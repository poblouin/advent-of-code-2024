package aoc2024.day01

import aoc2024.utils.FileLoader
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.io.File

class Day01Test :
    FileLoader(
        "01",
        part1 = listOf(11, 1660292),
        part2 = listOf(31, 22776016),
    ) {
    lateinit var solution: Day01

    @BeforeEach
    fun setUp() {
        solution = Day01()
    }

    @ParameterizedTest
    @MethodSource("argumentsPart1")
    fun part1(
        file: File,
        result: Int,
    ) {
        solution.part1(file.readLines()) shouldBe result
    }

    @ParameterizedTest
    @MethodSource("argumentsPart2")
    fun part2(
        file: File,
        result: Int,
    ) {
        solution.part2(file.readLines()) shouldBe result
    }
}
