package poker.hand

import poker.Combination
import poker.Type
import poker.card.Card

class Hand(private val _cards: List<Card>) : Comparable<Hand> {

    init {
        if (_cards.size < 5) {
            throw IllegalArgumentException("a Hand should have at least 5 cards")
        }
    }

    override fun compareTo(other: Hand): Int {
        for (it in combinations().sortedDescending().zip(other.combinations().sortedDescending())) {
            if (it.first > it.second) {
                return 1
            } else if (it.first < it.second) {
                return -1
            }
        }
        return 0
    }

    fun combinations(): List<Combination> {
        return Type.orderedTypes().flatMap { find(it) }.requireNoNulls()
    }

    private fun find(type: Type): List<Combination?> {
        return when (type) {
            Type.PAIR -> findAllCombinationUsing({ pair(this) })
            Type.HIGHEST -> findAllCombinationUsing({ highest(this) })
        }
    }

    private fun findAllCombinationUsing(finder: List<Card>.() -> Combination?): List<Combination?> {
        val cards = _cards.toMutableList()
        var combinations = emptyList<Combination?>()
        var found = finder(cards)
        while (cards.isNotEmpty() && found != null) {
            combinations = combinations.plus(found)
            cards.removeAll(found.cards)
            found = finder(cards)
        }
        return combinations
    }

    override fun toString(): String {
        return "$_cards"
    }

    companion object {

        private fun highest(cards: List<Card>) = Combination(Type.HIGHEST, listOfNotNull(cards.max()))

        private fun pair(cards: List<Card>): Combination? {
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
