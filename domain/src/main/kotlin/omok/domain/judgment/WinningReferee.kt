package omok.domain.judgment

import omok.domain.board.Position
import omok.domain.player.Stone

class WinningReferee : Referee() {
    fun hasFiveOrMoreStoneInRow(board: Map<Position, Stone?>, position: Position): Boolean {
        return countEveryContinuity(board, position).any { it >= OMOK_NUMBER }
    }
}