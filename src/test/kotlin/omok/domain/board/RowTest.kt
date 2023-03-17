package omok.domain.board

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RowTest {
    @Test
    fun `8의 위쪽 로우는 9이다`() {
        val row = Row.EIGHT

        Assertions.assertThat(row.up()).isEqualTo(Row.NINE)
    }

    @Test
    fun `15의 위쪽 로우는 존재하지 않는다`() {
        val row = Row.FIFTEEN

        Assertions.assertThat(row.up()).isNull()
    }

    @Test
    fun `8의 아래쪽 로우는 7이다`() {
        val row = Row.EIGHT

        Assertions.assertThat(row.down()).isEqualTo(Row.SEVEN)
    }

    @Test
    fun `1의 아래쪽 로우는 존재하지 않는다`() {
        val row = Row.ONE

        Assertions.assertThat(row.down()).isNull()
    }

    @Test
    fun `로우가 존재한다`() {
        val rowText = "9"

        Assertions.assertThat(rowText.toRow()).isEqualTo(Row.NINE)
    }

    @Test
    fun `로우가 존재하지 않는다`() {
        val rowText = "16"

        Assertions.assertThat(rowText.toRow()).isNull()
    }
}
