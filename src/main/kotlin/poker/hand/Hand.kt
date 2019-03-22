package poker.hand

import poker.Combination
import poker.Type
import poker.Type.*
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
        return findAll(values().sortedDescending(), _cards)
    }

    private fun findAll(arrayOfTypes: List<Type>, cards: List<Card>): List<Combination> {
        if (arrayOfTypes.isEmpty() || cards.isEmpty()) {
            return emptyList()
        }

        val combination = find(arrayOfTypes.first(), cards)
        return listOfNotNull(combination).plus(
            findAll(arrayOfTypes.drop(1), cards.minus(combination?.cards ?: emptyList()))
        )
    }

    private fun find(type: Type, cards: List<Card>): Combination? {
        return when (type) {
            HIGHEST -> highest(cards)
            PAIR, PAIRS -> pairsIn(cards)
            TRIPS -> tripsIn(cards)
            STRAIGHT -> straightIn(cards)
            FLUSH -> flushIn(cards)
            FULLHOUSE -> fullHouseIn(cards)
            QUADS -> quadsIn(cards)
            STRAIGHT_FLUSH -> straightFlushIn(cards)
        }
    }


    override fun toString(): String {
        return "$_cards"
    }

    companion object {

        private fun highest(cards: List<Card>) = Combination(HIGHEST, listOfNotNull(cards.max()))

        private fun pairsIn(cards: List<Card>): Combination? {
            val pairsValue = cards.groupingBy { it.value }.eachCount().filter { it.value == 2 }.keys
            return if (pairsValue.size == 2) {
                Combination(
                    PAIRS,
                    cards.filter { pairsValue.contains(it.value) }
                )
            } else if (pairsValue.size == 1) {
                Combination(
                    PAIR,
                    cards.filter { it.value == pairsValue.first() }
                )
            } else {
                null
            }
        }

        private fun tripsIn(cards: List<Card>): Combination? {
            val pairsValue = cards.groupingBy { it.value }.eachCount().filter { it.value == 3 }.keys
            return if (pairsValue.isNotEmpty()) {
                Combination(
                    TRIPS,
                    cards.filter { it.value == pairsValue.first() }
                )
            } else {
                null
            }
        }

        private fun straightIn(cards: List<Card>): Combination? {
            val sorted = cards.distinctBy { it.value }.sortedDescending()

            return if (sorted.first() - sorted.last() == sorted.size - 1) {
                Combination(
                    STRAIGHT,
                    sorted.take(5)
                )
            } else {
                null
            }
        }

        private fun flushIn(cards: List<Card>): Combination? {
            val flush = cards.groupingBy { it.color }.eachCount().filter { it.value >= 5 }.keys

            return if (flush.isNotEmpty()) {
                Combination(
                    FLUSH,
                    cards.filter { it.color == flush.first() }.sorted().take(5)
                )
            } else {
                null
            }
        }

        private fun fullHouseIn(cards: List<Card>): Combination? {

            val trips = tripsIn(cards)
            val pair = pairsIn(cards)

            return if (trips != null && pair != null) {
                Combination(
                    FULLHOUSE,
                    trips.cards + pair.cards
                )
            } else {
                null
            }
        }

        private fun quadsIn(cards: List<Card>): Combination? {
            val pairsValue = cards.groupingBy { it.value }.eachCount().filter { it.value == 4 }.keys
            return if (pairsValue.isNotEmpty()) {
                Combination(
                    QUADS,
                    cards.filter { it.value == pairsValue.first() }
                )
            } else {
                null
            }
        }

        private fun straightFlushIn(cards: List<Card>): Combination? {
            val straight = straightIn(cards)
            val flush = when {
                straight == null -> null
                else -> flushIn(straight.cards)
            }

            return if (flush != null) {
                Combination(
                    STRAIGHT_FLUSH,
                    flush.cards
                )
            } else {
                null
            }
        }

    }


}

private operator fun Card.minus(other: Card): Int {
    return this.value.ordinal - other.value.ordinal
}
