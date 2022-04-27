import org.junit.Assert.*
import org.junit.Test

class QueensAttackTest {

    val queensAttack = QueensAttack()

    /*
                * * * *
                * Q * *
                * * * *
     */
    @Test
    fun getNextPosition_directionIsTop_returnExpectedNextPosition() {
        val initialPosition = Pair(1, 1)
        val expectedNextPosition = Pair(0, 1)

        val result = queensAttack.getNextPosition(initialPosition, QueensAttack.Direction.UP)

        assertEquals(expectedNextPosition, result)
    }

    /*
                * * * *
                * Q * *
                * * * *
     */
    @Test
    fun getNextPosition_directionIsDown_returnExpectedNextPosition() {
        val initialPosition = Pair(1, 1)
        val expectedNextPosition = Pair(2, 1)

        val result = queensAttack.getNextPosition(initialPosition, QueensAttack.Direction.DOWN)

        assertEquals(expectedNextPosition, result)
    }

    /*
                * * * *
                * Q * *
                * * * *
     */
    @Test
    fun getNextPosition_directionIsRight_returnExpectedNextPosition() {
        val initialPosition = Pair(1, 1)
        val expectedNextPosition = Pair(1, 2)

        val result = queensAttack.getNextPosition(initialPosition, QueensAttack.Direction.RIGHT)

        assertEquals(expectedNextPosition, result)
    }

    /*
                * * * *
                * Q * *
                * * * *
     */
    @Test
    fun getNextPosition_directionIsLeft_returnExpectedNextPosition() {
        val initialPosition = Pair(1, 1)
        val expectedNextPosition = Pair(1, 0)

        val result = queensAttack.getNextPosition(initialPosition, QueensAttack.Direction.LEFT)

        assertEquals(expectedNextPosition, result)
    }

    /*
                * * * *
                * Q * *
                * * * *
     */
    @Test
    fun getNextPosition_directionIsDiaUpLeft_returnExpectedNextPosition() {
        val initialPosition = Pair(1, 1)
        val expectedNextPosition = Pair(0, 0)

        val result = queensAttack.getNextPosition(initialPosition, QueensAttack.Direction.DIAG_UP_LEFT)

        assertEquals(expectedNextPosition, result)
    }

    /*
                * * * *
                * Q * *
                * * * *
     */
    @Test
    fun getNextPosition_directionIsDiaUpRight_returnExpectedNextPosition() {
        val initialPosition = Pair(1, 1)
        val expectedNextPosition = Pair(0, 2)

        val result = queensAttack.getNextPosition(initialPosition, QueensAttack.Direction.DIAG_UP_RIGTH)

        assertEquals(expectedNextPosition, result)
    }

    /*
            * * * *
            * Q * *
            * * * *
 */
    @Test
    fun getNextPosition_directionIsDiaDownRight_returnExpectedNextPosition() {
        val initialPosition = Pair(1, 1)
        val expectedNextPosition = Pair(2, 2)

        val result = queensAttack.getNextPosition(initialPosition, QueensAttack.Direction.DIAG_DOWN_RIGT)

        assertEquals(expectedNextPosition, result)
    }

    /*
            * * * *
            * Q * *
            * * * *
 */
    @Test
    fun getNextPosition_directionIsDiaDownLeft_returnExpectedNextPosition() {
        val initialPosition = Pair(1, 1)
        val expectedNextPosition = Pair(2, 0)

        val result = queensAttack.getNextPosition(initialPosition, QueensAttack.Direction.DIAG_DOWN_LEFT)

        assertEquals(expectedNextPosition, result)
    }

    /*
            X * *
            * Q *
            * * *
 */
    @Test
    fun isNextPositionValid_nextPositionIsWithinBoardBoundsAndThereIsNoObstruction_returnTrue() {
        val bounds = 3
        val nextPosition = Pair(1, 2)
        val obstacles = mapOf<Pair<Int, Int>, String>(Pair(0, 0) to "OB")

        val result = queensAttack.isNextPositionValid(nextPosition, obstacles, bounds)

        assertTrue(result)
    }

    /*
            X * *
            Q * *
            * * *
 */
    @Test
    fun isNextPositionValid_nextPositionHasNegativeValuesAndThereIsNoObstruction_returnFalse() {
        val bounds = 3
        val nextPosition = Pair(1, -1)
        val obstacles = mapOf<Pair<Int, Int>, String>(Pair(0, 0) to "OB")

        val result = queensAttack.isNextPositionValid(nextPosition, obstacles, bounds)

        assertFalse(result)
    }

    /*
        X * *
        Q * *
        * * *
*/
    @Test
    fun isNextPositionValid_nextPositionHasValuesLargerOrEqualsToBoundsAndThereIsNoObstruction_returnFalse() {
        val bounds = 3
        val nextPosition = Pair(4, 3)
        val obstacles = mapOf<Pair<Int, Int>, String>(Pair(0, 0) to "OB")

        val result = queensAttack.isNextPositionValid(nextPosition, obstacles, bounds)

        assertFalse(result)
    }


    /*
    X * *
    Q * *
    * * *
*/
    @Test
    fun isNextPositionValid_nextPositionIsObstructionPosition_returnFalse() {
        val bounds = 3
        val nextPosition = Pair(0, 0)
        val obstacles = mapOf<Pair<Int, Int>, String>(Pair(0, 0) to "OB")

        val result = queensAttack.isNextPositionValid(nextPosition, obstacles, bounds)

        assertFalse(result)
    }

    /*
                        X * *
                        * * *
                        * Q *
*/
    @Test
    fun calculateTotalMovesForDirection_moveInUpDirection_returnExpectedTotalMoves() {
        val bounds = 3
        val expectedTotalMoves = 2
        val queenPosition = Pair(2, 1)
        val obstacles = mapOf<Pair<Int, Int>, String>(Pair(0, 0) to "OB")

        val result = queensAttack.calculateTotalMovesForDirection(bounds, queenPosition, QueensAttack.Direction.UP, obstacles)

        assertEquals(expectedTotalMoves, result)
    }

    /*
                        X * *
                        * * *
                        * * Q
*/
    @Test
    fun calculateTotalMovesForDirection_moveInDiaUpLeftDirection_returnExpectedTotalMoves() {
        val bounds = 3
        val expectedTotalMoves = 1
        val queenPosition = Pair(2, 2)
        val obstacles = mapOf<Pair<Int, Int>, String>(Pair(0, 0) to "OB")

        val result = queensAttack.calculateTotalMovesForDirection(bounds, queenPosition, QueensAttack.Direction.DIAG_UP_LEFT, obstacles)

        assertEquals(expectedTotalMoves, result)
    }
}