package poker

import org.junit.Test
import poker.combination.Combination
import poker.combination.Type


class TexasCombinaisonFinder {

    @Test
    fun five_cards_with_same_color_make_a_flush() {
        combinations_of("A♡ K♡ A♧ Q♡ J♡ 5♡") should_contains flush("A♡ K♡ 5♡ Q♡ J♡")
        combinations_of("K♡ K♢ 10♡ A♡ A♧ K♧ K♤") should_contains quads("K♡ K♢ K♧ K♤")
    }

    private fun flush(flush: String): Combination {
        return Combination(
            Type.FLUSH, flush.split(" ").map { card(it) })
    }

    private fun quads(cards: String): Combination {
        return Combination(
            Type.QUADS, cards.split(" ").map { card(it) })
    }
}