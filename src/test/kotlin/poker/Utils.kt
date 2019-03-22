package poker

import org.assertj.core.api.Assertions
import poker.card.Card
import poker.card.Color
import poker.card.Value
import poker.combination.Combination
import poker.combination.Type
import poker.hand.Hand

fun hand(hand: String) = Hand(hand.split(" ").map { card(it) })

fun card(s: String): Card {
    return Card(color(s.get(s.lastIndex))!!, value(s.dropLast(1))!!)
}

infix fun String.should_loose_against(hand: String) {
    Assertions.assertThat(hand(this)).isLessThan(hand(hand))
}
infix fun String.should_be_equals_to(hand: String) {
    Assertions.assertThat(hand(this)).isEqualByComparingTo(hand(hand))
}

infix fun String.should_win_against(hand: String) {
    Assertions.assertThat(hand(this)).isGreaterThan(hand(hand))
}

fun highest_card_of(s: String): Card {
    return hand(s).combinations().filter { it.type == Type.HIGHEST }.first().cards.first()
}

infix fun Card.should_be(c: String) {
    Assertions.assertThat(this).isEqualTo(card(c))
}

fun combinations_of(c: String): List<Combination> {
    return hand(c).combinations()
}


infix fun List<Combination>.should_contains(combination: Combination) {
    Assertions.assertThat(this).contains(combination)
}

private fun value(s: String): Value? {
    return Value.of(s)
}

private fun color(c: Char): Color? {
    return Color.of(c)
}
