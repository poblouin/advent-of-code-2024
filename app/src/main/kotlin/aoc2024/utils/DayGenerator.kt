package aoc2024.utils

import java.io.File
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun main(args: Array<String>) {
    val dayNumber = if (args.isNotEmpty()) args[0] else "${LocalDate.now().format(DateTimeFormatter.ofPattern("dd"))}"
    val dayToday = "day$dayNumber"
    val dayClass = "Day$dayNumber"
    val dayTestClass = "${dayClass}Test"
    val srcDirectory = File("src/main/kotlin/aoc2024/$dayToday")
    val testDirectory = File("src/test/kotlin/aoc2024/$dayToday")
    val testResourceDirectory = File("src/test/resources/$dayTestClass")
    val solutionSkeleton =
        """
        package aoc2024.$dayToday
        
        class $dayClass {
            fun part1(input: List<String>): Int = 0
        
            fun part2(input: List<String>): Int = 0
        }
        """.trimIndent()

    val testSkeleton =
        """
        package aoc2024.$dayToday

        import aoc2024.utils.FileLoader
        import io.kotest.matchers.shouldBe
        import org.junit.jupiter.api.BeforeEach
        import org.junit.jupiter.params.ParameterizedTest
        import org.junit.jupiter.params.provider.MethodSource
        import java.io.File

        class ${dayClass}Test :
            FileLoader(
                "$dayNumber",
                part1 = listOf(0, 0),
                part2 = listOf(0 ,0),
            ) {
            lateinit var solution: $dayClass

            @BeforeEach
            fun setUp() {
                solution = $dayClass()
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
        """.trimIndent()

    if (!srcDirectory.exists()) {
        srcDirectory.mkdir()
    }

    if (!testDirectory.exists()) {
        testDirectory.mkdir()
    }

    if (!testResourceDirectory.exists()) {
        testResourceDirectory.mkdir()
    }

    File(srcDirectory, "$dayClass.kt").takeIf { !it.exists() }?.writeText(solutionSkeleton)
    File(testDirectory, "$dayTestClass.kt").takeIf { !it.exists() }?.writeText(testSkeleton)
    listOf("input.txt", "sample.txt").forEach {
        val file = File(testResourceDirectory, it)
        if (!file.exists()) {
            file.createNewFile()
        }
    }
}
