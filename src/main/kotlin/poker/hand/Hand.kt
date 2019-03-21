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
        for (combinations in combinations().sortedDescending().zip(other.combinations().sortedDescending())) {
            if (combinations.first > combinations.second) {
                return 1
            } else if (combinations.first < combinations.second) {
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
            Type.PAIR, Type.PAIRS -> findPairs()
            Type.HIGHEST -> findHighest()
            Type.TRIPS -> findTrips()
        }
    }

    private fun findHighest() = findUsing({ highest(this) }, _cards.toMutableList())
    private fun findPairs() = findUsing({ pair(this) }, _cards.toMutableList())
    private fun findTrips() = findUsing({ trips(this) }, _cards.toMutableList())

    private fun findUsing(finder: List<Card>.() -> Combination?, cards: MutableList<Card>): List<Combination?> {
        var combinations = emptyList<Combination?>()
        var combination = finder(cards)
        while (cards.isNotEmpty() && combination != null) {
            cards.removeAll(combination.cards)
            combinations = combinations.plus(combination)
            combination = finder(cards)
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
            return if (pairsValue.size == 2) {
                Combination(
                    Type.PAIRS,
                    cards.filter { pairsValue.contains(it.value) }
                )
            } else if (pairsValue.size == 1) {
                Combination(
                    Type.PAIR,
                    cards.filter { it.value == pairsValue.first() }
                )
            } else {
                null
            }
        }

        private fun trips(cards: List<Card>): Combination? {
            val pairsValue = cards.groupingBy { it.value }.eachCount().filter { it.value == 3 }.keys
            return if (pairsValue.isNotEmpty()) {
                Combination(
                    Type.TRIPS,
                    cards.filter { it.value == pairsValue.first() }
                )
            } else {
                null
            }
        }

    }


}
