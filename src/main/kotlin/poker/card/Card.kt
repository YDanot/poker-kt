package poker.card

data class Card(val color: Color, val value: Value) : Comparable<Card> {

    override fun compareTo(other: Card): Int {
        return value.compareTo(other.value)
    }

    override fun toString(): String {
        return "${value.symbol}${color.symbol}"
    }


}