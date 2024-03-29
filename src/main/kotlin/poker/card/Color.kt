package poker.card

enum class Color(val symbol:Char) {

    HEART   ('♡'),
    DIAMOND ('♢'),
    CLUBS   ('♧'),
    SPADE   ('♤');

    companion object {
        fun of(value: Char): Color? {
            return values().find { it.symbol.equals(value) }
        }
    }
}
