package poker

import org.assertj.core.api.Assertions
import org.junit.Test

class HandBuilding {

    @Test
    fun five_cards_hand() = "A♡ K♡ 2♢ 3♢ 7♢".should_be_a_valid_hand()

    @Test
    fun four_cards_hand() = "A♡ 2♢ 3♢ 7♢".should_not_be_a_valid_hand()

    @Test
    fun six_cards_hand() = "A♡ 2♢ 3♢ 7♢ 4♢ 5♢".should_not_be_a_valid_hand()

}

private fun String.should_not_be_a_valid_hand() {
    try {
        val hand = hand(this)
        Assertions.fail(hand.toString() + "")
    } catch (e: IllegalArgumentException) {}
}

private fun String.should_be_a_valid_hand() {
    hand(this)
}
