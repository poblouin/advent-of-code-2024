package aoc2024.day05

class Day05 {
    fun part1(input: String): Int =
        input.parseInput().let { (rules, updates) ->
            updates
                .filter { it.isValid(rules) }
                .sumOf { it[it.size / 2] }
        }

    fun part2(input: String): Int =
        input.parseInput().let { (rules, updates) ->
            updates
                .filterNot { it.isValid(rules) }
                .map { it.order(rules) }
                .sumOf { it[it.size / 2] }
        }

    fun String.parseInput(): Pair<List<List<Int>>, List<MutableList<Int>>> =
        split("\n\n").let { (rulesStr, updatesStr) ->
            rulesStr
                .lines()
                .map { it.split("|").map(String::toInt) } to
                updatesStr
                    .lines()
                    .map { line -> line.split(",").map(String::toInt).toMutableList() }
        }

    fun MutableList<Int>.isValid(rules: List<List<Int>>) =
        rules.all { (r1, r2) -> !containsAll(listOf(r1, r2)) || indexOf(r1) < indexOf(r2) }

    fun MutableList<Int>.order(rules: List<List<Int>>) =
        apply {
            sortWith { a, b ->
                when {
                    rules.any { (r1, r2) -> r1 == a && r2 == b } -> -1
                    rules.any { (r1, r2) -> r1 == b && r2 == a } -> 1
                    else -> 0
                }
            }
        }
}
