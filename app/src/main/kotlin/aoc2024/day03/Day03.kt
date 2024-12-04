package aoc2024.day03

class Day03 {
    fun part1(input: String): Int =
        """mul\((\d{1,3}),(\d{1,3})\)"""
            .toRegex()
            .findAll(input)
            .map { it.groupValues[1].toInt() to it.groupValues[2].toInt() }
            .asSequence()
            .fold(0) { acc, (a, b) -> acc + a * b }

    fun part2(input: String): Int =
        """do\(\)|don't\(\)|mul\((\d{1,3}),(\d{1,3})\)"""
            .toRegex()
            .findAll(input)
            .map { if (it.groupValues.first().contains("do")) it.groupValues[0] else "${it.groupValues[1]},${it.groupValues[2]}" }
            .toList()
            .removeAllBetweenMarkers()
            .sumOf { it.split(",").map { it.toInt() }.reduce { a, b -> a * b } }

    fun List<String>.removeAllBetweenMarkers(): List<String> =
        fold(false to emptyList<String>()) { (removing, acc), element ->
            when {
                element == "don't()" -> true to acc
                element == "do()" -> false to acc
                removing -> removing to acc
                else -> removing to acc + element
            }
        }.second
}
