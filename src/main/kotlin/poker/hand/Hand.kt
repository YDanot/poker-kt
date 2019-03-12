package poker.hand

import poker.card.Card

data class Hand(val cards: List<Card>) {
    fun highest(): Card {
        return cards.max()!!
    }
}
