package aoc2024.day07

class Day07 {
    fun part1(input: List<String>): Long =
        input
            .parse()
            .fold(0L) { acc, (value, values) ->
                acc + if (solvable(value, values)) value else 0L
            }

    fun part2(input: List<String>): Long =
        input
            .parse()
            .fold(0L) { acc, (value, values) ->
                acc + if (solvable(value, values, true)) value else 0L
            }

    fun List<String>.parse() =
        map {
            it.split(':').let {
                it[0].toLong() to it[1].trim().split("\\s+".toRegex()).map { it.trim().toLong() }
            }
        }

    fun solvable(
        value: Long,
        values: List<Long>,
        extraOp: Boolean = false,
    ) = (values.size - 1).generateOperatorCombinations(extraOp).any {
        values
            .drop(1)
            .zip(it)
            .fold(values.first()) { acc, (value, op) ->
                when (op) {
                    "+" -> acc + value
                    "*" -> acc * value
                    else -> "$acc$value".toLong()
                }
            } == value
    }

    fun Int.generateOperatorCombinations(extraOp: Boolean = false): List<List<String>> =
        List(this) {
            listOf("+", "*") + if (extraOp) listOf("||") else emptyList()
        }.fold(listOf(listOf())) { acc, ops ->
            acc.flatMap { combination ->
                ops.map { combination + it }
            }
        }
}
