package aoc2024.utils

import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.provider.Arguments
import java.io.File

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class FileLoader(
    private val dayNumber: String,
    private val part1: List<Int>,
    private val part2: List<Int>,
) {
    companion object {
        fun createArguments(
            dayNumber: String,
            results: List<Int>,
        ) = listOf(
            Arguments.of(getResourceFile(dayNumber, "sample.txt"), results[0]),
            Arguments.of(getResourceFile(dayNumber, "input.txt"), results[1]),
        )

        private fun getResourceFile(
            dayNumber: String,
            filename: String,
        ): File = File(FileLoader::class.java.getResource("/Day${dayNumber}Test/$filename")!!.path)
    }

    fun argumentsPart1() = createArguments(dayNumber, part1)

    fun argumentsPart2() = createArguments(dayNumber, part2)
}
