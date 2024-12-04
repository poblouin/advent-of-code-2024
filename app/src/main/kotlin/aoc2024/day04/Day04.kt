package aoc2024.day04

class Day04 {
    fun part1(input: String): Int {
        val grid = input.trim().lines()
        val dirs =
            listOf(
                0 to 1,
                0 to -1,
                1 to 0,
                -1 to 0,
                1 to 1,
                -1 to -1,
                1 to -1,
                -1 to 1,
            )

        return grid.indices.sumOf { r ->
            grid[0].indices.sumOf { c ->
                dirs.count { (dr, dc) ->
                    (0..3).all { i ->
                        val newR = r + dr * i
                        val newC = c + dc * i
                        newR in grid.indices &&
                            newC in grid[0].indices &&
                            grid[newR][newC] == "XMAS"[i]
                    }
                }
            }
        }
    }

    fun part2(input: String): Int {
        val grid = input.trim().lines()
        val rows = grid.size
        val cols = grid[0].length
        var count = 0

        for (r in 1 until rows - 1) {
            for (c in 1 until cols - 1) {
                val diag1 = "${grid[r - 1][c - 1]}${grid[r][c]}${grid[r + 1][c + 1]}"
                val diag2 = "${grid[r - 1][c + 1]}${grid[r][c]}${grid[r + 1][c - 1]}"

                if ((diag1 == "MAS" || diag1 == "SAM") &&
                    (diag2 == "MAS" || diag2 == "SAM")
                ) {
                    count++
                }
            }
        }

        return count
    }
}
