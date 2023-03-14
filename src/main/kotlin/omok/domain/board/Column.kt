package omok.domain.board

enum class Column(val axis: Int) {
    A(0),
    B(1),
    C(2),
    D(3),
    E(4),
    F(5),
    G(6),
    H(7),
    I(8),
    J(9),
    K(10),
    L(11),
    M(12),
    N(13),
    O(14);

    fun right(): Column? = values().find { it.axis == axis + 1 }
    fun left(): Column? = values().find { it.axis == axis - 1 }
}