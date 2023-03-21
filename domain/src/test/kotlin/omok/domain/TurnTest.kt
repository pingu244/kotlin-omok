package omok.domain

import omok.domain.player.Black
import omok.domain.player.White
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TurnTest {

    @Test
    fun `블랙 다음 플레이어는 화이트이다`() {
        val turn = Turn(setOf(Black, White))

        turn.changeTurn()

        assertThat(turn.now).isEqualTo(White)
    }
}
