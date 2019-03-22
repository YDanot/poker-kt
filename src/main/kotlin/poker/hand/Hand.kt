package poker.hand

import poker.card.Card
import poker.combination.Combination
import poker.combination.Type

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
        return findAllCombinations(Type.values().sortedDescending(), _cards)
    }

    private fun findAllCombinations(types: List<Type>, cards: List<Card>): List<Combination> {
        if (types.isEmpty() || cards.isEmpty()) {
            return emptyList()
        }

        val combination = types.first().find(cards)
        return listOfNotNull(combination).plus(
            findAllCombinations(types.drop(1), cards.minus(combination?.cards ?: emptyList()))
        )
    }

    override fun toString(): String {
        return "$_cards"
    }

}
