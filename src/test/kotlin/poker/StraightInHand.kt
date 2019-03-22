package poker

import org.junit.Test

class StraightInHand {

    @Test
    fun five_folllowing_cards_make_a_straight() {
        combinations_of("A♡ K♢ 10♤ Q♡ J♢") should_contains straight("A♡ K♢ 10♤ Q♡ J♢")
    }

    private fun straight(straight: String): Combination {
        return Combination(
            Type.STRAIGHT, straight.split(" ").map { card(it) })
    }
}


