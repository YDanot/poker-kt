package poker.hand

import poker.card.Card

data class Hand(val cards: List<Card>) {

    init {
        if (cards.size != 5) {
            throw IllegalArgumentException("a Hand should have 5 cards")
        }
    }

    fun highest(): Card {
        return cards.max()!!
    }

    fun winsAgainst(hand: Hand): Boolean {
        return highest() > hand.highest()
    }
}
