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

    fun part2(input: String): Int {
        input.parse().let {
            val candidatePositions = mutableSetOf<Position>()

            for (y in 0 until it.maxY) {
                for (x in 0 until it.maxX) {
                    val position = Position(x, y)
                    if (position == it.currentPosition ||
                        it.map[y][x] == '#'
                    ) {
                        continue
                    }

                    val currentGrid = it.copy()
                    currentGrid.map =
                        currentGrid.map.mapIndexed { mapY, row ->
                            if (mapY == y) {
                                row.substring(0, x) + '#' + row.substring(x + 1)
                            } else {
                                row
                            }
                        }

                    val visited = mutableSetOf<Pair<Position, Direction>>()

                    try {
                        while (true) {
                            val state = currentGrid.currentPosition to currentGrid.direction
                            if (state in visited) {
                                candidatePositions.add(position)
                                break
                            }
                            visited.add(state)
                            currentGrid.move()
                        }
                    } catch (_: IllegalStateException) {
                        continue
                    }
                }
            }

            return candidatePositions.size
        }
    }

    class Grid(
        var map: List<String>,
        val maxX: Int,
        val maxY: Int,
        var currentPosition: Position,
        var positions: MutableSet<Position>,
        var direction: Direction,
    ) {
        fun copy() =
            Grid(
                map = map.toList(),
                maxX = maxX,
                maxY = maxY,
                currentPosition = currentPosition.copy(),
                positions = positions.toMutableSet(),
                direction = direction,
            )
    }

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
