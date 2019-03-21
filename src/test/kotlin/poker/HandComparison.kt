package poker

import org.assertj.core.api.Assertions
import org.junit.Test

class HandComparison {

    @Test
    fun highestCardAceVsKing() = "A♡ K♡ 2♢ 3♢ 7♢" should_win_against "K♧ 6♧ 2♧ 3♧ 7♤"

    @Test
    fun highestCardKingVsAce() = "K♧ 6♧ 2♧ 3♧ 7♤" should_loose_against "A♡ K♡ 2♢ 3♢ 7♢"

    @Test
    fun highestPairKingVsHighestCardAce() = "K♧ K♤ 2♧ 3♧ 7♤" should_win_against "A♡ K♡ 2♢ 3♡ 7♢"

    @Test
    fun highestPairKingVsHighestPairQueen() = "K♧ K♤ 2♧ 3♧ 7♤" should_win_against "Q♡ Q♡ A♢ 3♡ 7♢"

}
