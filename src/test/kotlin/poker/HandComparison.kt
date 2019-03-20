package poker

import org.assertj.core.api.Assertions
import org.junit.Test

class HandComparison {

    @Test
    fun highestCardAceVsKing() = "A♡ K♡ 2♢ 3♢ 7♢" should_win_against "K♧ 6♧ 2♧ 3♧ 7♤"

    @Test
    fun highestCardKingVsAce() = "K♧ 6♧ 2♧ 3♧ 7♤" should_loose_against "A♡ K♡ 2♢ 3♢ 7♢"

}

private infix fun String.should_loose_against(s: String) {
    Assertions.assertThat(hand(this).winsAgainst(hand(s))).isFalse()
}

private infix fun String.should_win_against(s: String) {
    Assertions.assertThat(hand(this).winsAgainst(hand(s))).isTrue()
}
