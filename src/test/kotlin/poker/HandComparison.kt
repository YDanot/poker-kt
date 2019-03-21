package poker

import org.junit.Test

class HandComparison {

    @Test
    fun highestCardAceVsKing() = "A♡ K♡ 2♢ 3♢ 7♢" should_win_against "K♧ 6♧ 2♧ 3♧ 7♤"

    @Test
    fun highestCardKingVsAce() = "K♧ 6♧ 2♧ 3♧ 7♤" should_loose_against "A♡ K♡ 2♢ 3♢ 7♢"

    @Test
    fun split() = "K♧ 6♧ 2♧ 3♧ 7♤" should_be_equals_to "K♡ 6♡ 2♡ 3♢ 7♡"

    @Test
    fun secondHighest() = "K♧ 6♧ 2♧ 3♧ 7♤" should_loose_against "Q♡ K♡ 2♢ 3♢ 7♢"

    @Test
    fun highestPairKingVsHighestCardAce() = "K♧ K♤ 2♧ 3♧ 7♤" should_win_against "A♡ K♡ 2♢ 3♡ 7♢"

    @Test
    fun highestPairKingVsHighestPairQueen() = "K♧ K♤ 2♧ 3♧ 7♤" should_win_against "Q♡ Q♧ A♢ 3♡ 7♢"

    @Test
    fun pairsShouldWinAgainstSinglePair() = "K♧ K♤ 7♧ 3♧ 7♤" should_win_against "A♡ 5♡ A♢ 3♡ 7♢"

    @Test
    fun pairs_K_A_shouldWinAgainstPairs_K_Q() = "K♧ K♤ A♧ 3♧ A♤" should_win_against "K♡ Q♡ K♢ 3♡ Q♢"

    @Test
    fun trips_shouldWinAgainstPairs() = "K♧ K♤ K♡ 3♧ A♤" should_win_against "A♧ A♡ K♢ Q♡ Q♢"

}
