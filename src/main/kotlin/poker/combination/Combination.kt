package poker.combination

import poker.combination.Type.FULLHOUSE
import poker.card.Card
import poker.card.Value

data class Combination(val type: Type, val cards: List<Card>) : Comparable<Combination> {

    override fun compareTo(other: Combination): Int =
        compareValuesBy(this, other, { it.type }, { it.comparisonValue() })

    private fun comparisonValue(): Value {
        return when (type) {
            FULLHOUSE -> valueOfTrips()
            else -> maxValue()
        }
    }

    private fun valueOfTrips() = cards.groupingBy { it.value }.eachCount().filter { it.value == 3 }.keys.first()

    private fun maxValue() = cards.max()!!.value

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Combination) return false

        return this.compareTo(other) == 0
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + cards.sumBy { it.hashCode() }
        return result
    }


}

