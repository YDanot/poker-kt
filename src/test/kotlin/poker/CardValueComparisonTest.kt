package poker

import org.assertj.core.api.Assertions
import org.junit.Test


class CardValueComparisonTest {

    @Test
    fun ace_should_be_higher_than_king() = "A♡".should_be_higher_than("K♡")

    @Test
    fun king_should_be_higher_than_queen() = "K♡".should_be_higher_than("Q♡")

    @Test
    fun queen_should_be_higher_than_jack() = "Q♡".should_be_higher_than("J♡")

    @Test
    fun jack_should_be_higher_than_ten() = "J♡".should_be_higher_than("10♡")

    @Test
    fun ten_should_be_higher_than_nine() = "10♡".should_be_higher_than("9♡")

    @Test
    fun nine_should_be_higher_than_eight() = "9♡".should_be_higher_than("8♡")

    @Test
    fun eight_should_be_higher_than_seven() = "8♡".should_be_higher_than("7♡")

    @Test
    fun seven_should_be_higher_than_six() = "7♡".should_be_higher_than("6♡")

    @Test
    fun six_should_be_higher_than_five() = "6♢".should_be_higher_than("5♢")

    @Test
    fun five_should_be_higher_than_four() = "5♢".should_be_higher_than("4♢")

    @Test
    fun four_should_be_higher_than_three() = "4♡".should_be_higher_than("3♡")

    @Test
    fun three_should_be_higher_than_two() = "3♡".should_be_higher_than("2♡")

    @Test
    fun color_should_not_be_valuable() = "A♡".should_have_same_value_as("A♢")

    private fun String.should_be_higher_than(other: String) {
        Assertions.assertThat(card(this)).isGreaterThan(card(other))
    }

    private fun String.should_have_same_value_as(other: String) {
        Assertions.assertThat(card(this)).isEqualByComparingTo(card(other))
    }

}
