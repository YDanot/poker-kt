package poker.hand

import poker.Combination
import poker.Type
import poker.card.Card

class Hand(val _cards: List<Card>) {

    private val cards by lazy { _cards.toMutableList() }

    init {
        if (_cards.size != 5) {
            throw IllegalArgumentException("a Hand should have 5 cards")
        }
    }

    fun winsAgainst(hand: Hand): Boolean {
        return combinations().sortedDescending().zip(hand.combinations().sortedDescending())
            .any { it.first > it.second }
    }

    fun combinations(): List<Combination> {
        return Type.orderedTypes().map { find(it) }.filterNotNull()
    }

    private fun find(type: Type): Combination? {
        return when (type) {
            Type.PAIR -> pair(cards)
            Type.HIGHEST -> highest(cards)
        }
    }

    companion object {

        private fun highest(cards: MutableList<Card>) = Combination(Type.HIGHEST, listOf(cards.max()!!))

        private fun pair(cards: MutableList<Card>): Combination? {
            val pairsValue = cards.groupingBy { it.value }.eachCount().filter { it.value == 2 }.keys
            return if (pairsValue.isNotEmpty()) {
                Combination(
                    Type.PAIR,
                    cards.filter { it.value == pairsValue.first() }
                )
            } else {
                null
            }
        }
    }

}
