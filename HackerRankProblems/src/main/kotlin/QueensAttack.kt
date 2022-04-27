import javax.swing.text.Position

/*
    Solving the Queen's Attack Problem On Hacker Rank: https://www.hackerrank.com/contests/coden-chill-winter-edition/challenges/queens-attack-2
 */

class QueensAttack {

    fun getNextPosition(initialPosition: Pair<Int, Int>, direction: Direction): Pair<Int, Int> {
        val newRow = initialPosition.first + direction.subRow
        val newCol = initialPosition.second + direction.subCol
        return Pair(newRow, newCol)
    }

    fun isNextPositionValid(nextPosition: Pair<Int, Int>, obstacles: Map<Pair<Int, Int>, String>, bounds: Int): Boolean {
        val (row, column) = nextPosition
        return row in 0 until bounds &&
               column in 0 until bounds &&
               obstacles[nextPosition] == null
    }

    fun calculateTotalMovesForDirection(bounds: Int,
                                        queenPosition: Pair<Int, Int>,
                                        direction: Direction,
                                        obstacles: Map<Pair<Int, Int>, String>,
                                        total: Int = 0): Int {
        val nextPosition = getNextPosition(queenPosition, direction)
        return if(isNextPositionValid(nextPosition, obstacles, bounds)) {
            calculateTotalMovesForDirection(bounds, nextPosition, direction, obstacles, total + 1)
        } else {
            total
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

    /*fun queensAttack(n: Int, k: Int, r_q: Int, c_q: Int, obstacles: Array<Array<Int>>): Int {
        val quesPos : Pair<Int, Int> = Pair(r_q - 1, c_q - 1)

        val mapOfObstacles = obstacles.associate { row ->
            Pair(row[0] - 1, row[1] - 1) to "Obstacle"
        }

        var total = 0
        Direction.values().forEach { direction ->
            total += calculateTotalMovesForDirection(n, quesPos, direction, mapOfObstacles)
        }

        return total
    }*/

}