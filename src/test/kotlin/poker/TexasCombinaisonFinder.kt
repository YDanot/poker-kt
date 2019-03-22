package poker

import org.junit.Test
import poker.card.Card
import poker.card.Color
import poker.card.Value
import poker.hand.Hand


class TexasCombinaisonFinder{

    @Test
    fun five_cards_with_same_color_make_a_flush() {
        combinations_of("A♡ K♡ A♧ Q♡ J♡ 5♡") should_contains flush("A♡ K♡ 5♡ Q♡ J♡")
        combinations_of("K♡ K♢ 10♡ A♡ A♧ K♧ K♤") should_contains quads("K♡ K♢ K♧ K♤")
        println(Hand(deck()).combinations())
    }

    private fun deck():List<Card>{
        var deck = emptyList<Card>()
        Color.values().forEach { deck = deck.plus(buildAllCardOf(it)) }

        return deck
    }

    private fun buildAllCardOf(color: Color) : List<Card>{
        var deck = emptyList<Card>()
        Value.values().forEach {
            deck = deck.plus(Card(color,it))
        }
        return deck
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