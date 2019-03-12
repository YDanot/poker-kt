package poker

import org.assertj.core.api.Assertions
import org.junit.Test
import poker.card.Card
import poker.hand.Hand

class HighestCardInHand {

    @Test
    fun highestCardAce() = highest_card_of("A♡ K♡ 2♢ 3♢ 7♢").should_be("A♡")

    @Test
    fun highestCardKing() = highest_card_of("6♡ K♡ 2♢ 3♢ 7♢").should_be("K♡")

    private fun highest_card_of(hand: String): Card {
        return Hand(hand.split(" ").map { card(it) }).highest()
    }

}

private fun Card.should_be(s: String) {
    Assertions.assertThat(this).isEqualTo(card(s))
}
