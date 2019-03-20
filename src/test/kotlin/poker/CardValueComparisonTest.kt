package poker

import org.assertj.core.api.Assertions
import org.junit.Test


class CardValueComparisonTest {

    @Test
    fun natural_card_order_should_be_used(){
        "A♡" should_be_higher_than "K♡"
        "K♡" should_be_higher_than "Q♡"
        "Q♡" should_be_higher_than "J♡"
        "J♡" should_be_higher_than "10♡"
        "10♡" should_be_higher_than "9♡"
        "9♡" should_be_higher_than "8♡"
        "8♡" should_be_higher_than "7♡"
        "7♡" should_be_higher_than "6♡"
        "6♢" should_be_higher_than "5♢"
        "5♢" should_be_higher_than "4♢"
        "4♡" should_be_higher_than "3♡"
        "3♡" should_be_higher_than "2♡"
    }

    @Test
    fun color_should_not_be_valuable() = "A♡" should_have_same_value_as "A♢"

}

private infix fun String.should_be_higher_than(other: String) {
    Assertions.assertThat(card(this)).isGreaterThan(card(other))
}

private infix fun String.should_have_same_value_as(other: String) {
    Assertions.assertThat(card(this)).isEqualByComparingTo(card(other))
}
