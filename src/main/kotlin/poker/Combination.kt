package poker

import poker.card.Card

data class Combination(val type: Type, val cards: List<Card>) : Comparable<Combination> {

    override fun compareTo(other: Combination): Int =
        compareValuesBy(this, other, { it.type }, { it.cards.max() })

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

