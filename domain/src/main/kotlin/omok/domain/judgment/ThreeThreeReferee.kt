package omok.domain.judgment

import omok.domain.board.Position
import omok.domain.player.Stone

class ThreeThreeReferee(target: Stone) : PlacementReferee(target) {
    override fun isForbiddenPlacement(board: Map<Position, Stone?>, position: Position): Boolean {
        return countThree(board, position) >= 2
    }

    private fun countThree(board: Map<Position, Stone?>, position: Position): Int {
        return listOf(
            isVerticalThree(board, position),
            isUpwardDiagonalThree(board, position),
            isHorizontalThree(board, position),
            isDownwardDiagonalThree(board, position)
        ).count { it }
    }

    private fun isVerticalThree(board: Map<Position, Stone?>, position: Position): Boolean {
        val northEmptyPosition = findNorthEmptyPosition(board, position)
        if (northEmptyPosition != null && isVerticalOpenFour(board.toMutableMap(), northEmptyPosition)) return true
        val southEmptyPosition = findSouthEmptyPosition(board, position)
        if (southEmptyPosition != null && isVerticalOpenFour(board.toMutableMap(), southEmptyPosition)) return true
        return false
    }

    private fun isVerticalOpenFour(board: MutableMap<Position, Stone?>, position: Position): Boolean {
        board[position] = target
        if (countVerticalContinuity(board, position) == FOUR_NUMBER) return isNorthOpen(board, position) && isSouthOpen(board, position)
        return false
    }

    private tailrec fun isNorthOpen(board: MutableMap<Position, Stone?>, position: Position): Boolean {
        return findNorthEmptyPosition(board, position) != null
    }

    private fun isSouthOpen(board: MutableMap<Position, Stone?>, position: Position): Boolean {
        return findSouthEmptyPosition(board, position) != null
    }

    private fun isUpwardDiagonalThree(board: Map<Position, Stone?>, position: Position): Boolean {
        val northEastEmptyPosition = findNorthEastEmptyPosition(board, position)
        if (northEastEmptyPosition != null && isUpwardDiagonalOpenFour(board.toMutableMap(), northEastEmptyPosition)) return true
        val southWestEmptyPosition = findSouthWestEmptyPosition(board, position)
        if (southWestEmptyPosition != null && isUpwardDiagonalOpenFour(board.toMutableMap(), southWestEmptyPosition)) return true
        return false
    }

    private fun isUpwardDiagonalOpenFour(board: MutableMap<Position, Stone?>, position: Position): Boolean {
        board[position] = target
        if (countUpwardDiagonalContinuity(board, position) == FOUR_NUMBER) return isNorthEastOpen(board, position) && isSouthWestOpen(board, position)
        return false
    }

    private tailrec fun isNorthEastOpen(board: MutableMap<Position, Stone?>, position: Position): Boolean {
        return findNorthEastEmptyPosition(board, position) != null
    }

    private fun isSouthWestOpen(board: MutableMap<Position, Stone?>, position: Position): Boolean {
        return findSouthWestEmptyPosition(board, position) != null
    }

    private fun isHorizontalThree(board: Map<Position, Stone?>, position: Position): Boolean {
        val eastEmptyPosition = findEastEmptyPosition(board, position)
        if (eastEmptyPosition != null && isHorizontalOpenFour(board.toMutableMap(), eastEmptyPosition)) return true
        val westEmptyPosition = findWestEmptyPosition(board, position)
        if (westEmptyPosition != null && isHorizontalOpenFour(board.toMutableMap(), westEmptyPosition)) return true
        return false
    }

    private fun isHorizontalOpenFour(board: MutableMap<Position, Stone?>, position: Position): Boolean {
        board[position] = target
        if (countHorizontalContinuity(board, position) == FOUR_NUMBER) return isEastOpen(board, position) && isWestOpen(board, position)
        return false
    }

    private tailrec fun isEastOpen(board: MutableMap<Position, Stone?>, position: Position): Boolean {
        return findEastEmptyPosition(board, position) != null
    }

    private fun isWestOpen(board: MutableMap<Position, Stone?>, position: Position): Boolean {
        return findWestEmptyPosition(board, position) != null
    }

    private fun isDownwardDiagonalThree(board: Map<Position, Stone?>, position: Position): Boolean {
        val southEastEmptyPosition = findSouthEastEmptyPosition(board, position)
        if (southEastEmptyPosition != null && isDownwardDiagonalOpenFour(board.toMutableMap(), southEastEmptyPosition)) return true
        val northWestEmptyPosition = findNorthWestEmptyPosition(board, position)
        if (northWestEmptyPosition != null && isDownwardDiagonalOpenFour(board.toMutableMap(), northWestEmptyPosition)) return true
        return false
    }

    private fun isDownwardDiagonalOpenFour(board: MutableMap<Position, Stone?>, position: Position): Boolean {
        board[position] = target
        if (countDownwardDiagonalContinuity(board, position) == FOUR_NUMBER) return isSouthEastOpen(board, position) && isNorthWestOpen(board, position)
        return false
    }

    private tailrec fun isSouthEastOpen(board: MutableMap<Position, Stone?>, position: Position): Boolean {
        return findSouthEastEmptyPosition(board, position) != null
    }

    private fun isNorthWestOpen(board: MutableMap<Position, Stone?>, position: Position): Boolean {
        return findNorthWestEmptyPosition(board, position) != null
    }
}
