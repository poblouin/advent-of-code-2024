package aoc2024.day06

class Day06 {
    fun part1(input: String): Int {
        input.parse().let {
            while (true) {
                try {
                    it.move()
                } catch (_: IllegalStateException) {
                    break
                }
            }

            return it.positions.size
        }
    }

    fun part2(input: String): Int = 0

    class Grid(
        val map: List<String>,
        val maxX: Int,
        val maxY: Int,
        var currentPosition: Position,
        var positions: MutableSet<Position>,
        var direction: Direction,
    )

    data class Position(
        val x: Int,
        val y: Int,
    )

    enum class Direction {
        NORTH,
        EAST,
        SOUTH,
        WEST,
    }

    fun String.parse() =
        lines().reversed().let {
            val currentPosition =
                it.indexOfFirst { row -> row.contains('^') }.let { y ->
                    Position(
                        x = it[y].indexOf('^'),
                        y = y,
                    )
                }

            Grid(
                map = it,
                maxX = it.first().length,
                maxY = it.size,
                currentPosition = currentPosition,
                positions = mutableSetOf(currentPosition),
                direction = Direction.NORTH,
            )
        }

    fun Grid.move() {
        val newPosition =
            when (direction) {
                Direction.NORTH -> currentPosition.copy(y = currentPosition.y + 1)
                Direction.EAST -> currentPosition.copy(x = currentPosition.x + 1)
                Direction.SOUTH -> currentPosition.copy(y = currentPosition.y - 1)
                Direction.WEST -> currentPosition.copy(x = currentPosition.x - 1)
            }

        if (newPosition.x < 0 || newPosition.x >= maxX || newPosition.y < 0 || newPosition.y >= maxY) {
            throw IllegalStateException("Out of bounds")
        }

        if (map[newPosition.y][newPosition.x] == '#') {
            direction =
                when (direction) {
                    Direction.NORTH -> Direction.EAST
                    Direction.EAST -> Direction.SOUTH
                    Direction.SOUTH -> Direction.WEST
                    Direction.WEST -> Direction.NORTH
                }

            return
        }

        positions += newPosition
        currentPosition = newPosition
    }
}
