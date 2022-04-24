/*
    Solving the Queen's Attack Problem On Hacker Rank: https://www.hackerrank.com/contests/coden-chill-winter-edition/challenges/queens-attack-2
 */

class QueensAttack {
    fun queensAttack(n: Int, k: Int, r_q: Int, c_q: Int, obstacles: Array<Array<Int>>): Int {
        val quesPos : Pair<Int, Int> = Pair(r_q - 1, c_q - 1)

        val mapOfObstacles = obstacles.associate { row ->
            Pair(row[0] - 1, row[1] - 1) to 11
        }

        var sum = 0
        Direction.values().forEach {
            sum += checkPos(it, quesPos, n, 0, mapOfObstacles)
        }

        return sum

    }

    fun checkPos(direction: Direction, pos: Pair<Int, Int>, max: Int, sum: Int, obstacles: Map<Pair<Int, Int>, Int>) : Int {
        val nextPosition = getNextPositionOrNull(pos, direction, max)
        return if(nextPosition == null || obstacles[nextPosition] != null) {
            sum
        } else {
            checkPos(direction, nextPosition, max, sum + 1, obstacles)
        }
    }

    fun getNextPositionOrNull(initialPosition: Pair<Int, Int>, direction: Direction, max: Int): Pair<Int, Int>? {
        val newRow = initialPosition.first + direction.subRow
        val newCol = initialPosition.second + direction.subCol
        return if(newRow == -1 || newCol == -1 || newRow > max - 1 || newCol > max - 1) {
            null
        } else {
            Pair(newRow, newCol)
        }
    }

    enum class Direction(val subRow: Int, val subCol: Int) {
        UP(-1, 0),
        DOWN(1, 0),
        LEFT(0, -1),
        RIGHT(0, 1),
        DIAG_UP_RIGTH(-1, 1),
        DIAG_UP_LEFT(-1, -1),
        DIAG_DOWN_RIGT(1, 1),
        DIAG_DOWN_LEFT(1, -1)
    }

}