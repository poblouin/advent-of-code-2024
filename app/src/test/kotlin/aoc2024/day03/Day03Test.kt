package aoc2024.day03

import aoc2024.utils.FileLoader
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.io.File

class Day03Test :
    FileLoader(
        "03",
        part1 = listOf(161, 175615763),
        part2 = listOf(48, 74361272),
    ) {
    lateinit var solution: Day03

    @BeforeEach
    fun setUp() {
        solution = Day03()
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
