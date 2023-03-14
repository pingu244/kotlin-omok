package omok.domain.board

import omok.domain.player.Stone

class Board(private val _positions: MutableMap<Position, Stone?> = POSITIONS.associateWith { null }.toMutableMap()) {
    val positions: Map<Position, Stone?>
        get() = _positions.toMap()

    fun isEmpty(position: Position) = _positions[position] == null

    fun place(position: Position, stone: Stone) {
        check(isEmpty(position)) { "[ERROR] 해당 위치는 비어있지 않습니다." }
        _positions[position] = stone
    }

    companion object {
        val POSITIONS: List<Position> = Column.values().flatMap { column ->
            Row.values().map { row ->
                Position(column, row)
            }
        }
    }
}