package aoc2024.day02

import aoc2024.utils.FileLoader
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.io.File

class Day02Test :
    FileLoader(
        "02",
        part1 = listOf(2, 502),
        part2 = listOf(4, 544),
    ) {
    lateinit var solution: Day02

    @BeforeEach
    fun setUp() {
        solution = Day02()
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
