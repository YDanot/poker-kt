package poker

import poker.card.Card
import poker.card.Color
import poker.card.Value

fun card(s: String): Card {
    return Card(color(s.get(s.lastIndex))!!, value(s.dropLast(1))!!)
}

private fun value(s: String): Value? {
    return Value.of(s)
}

private fun color(c: Char): Color? {
    return Color.of(c);
}