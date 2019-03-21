package poker

import org.junit.Test

class HighestCardInHand {

    @Test
    fun highest_card_of_a_hand_should_be_card_with_the_highest_value() {
        highest_card_of("A♡ K♡ 2♢ 3♢ 7♢") should_be "A♡"
        highest_card_of("6♡ K♡ 2♢ 3♢ 7♢") should_be "K♡"
    }
}
