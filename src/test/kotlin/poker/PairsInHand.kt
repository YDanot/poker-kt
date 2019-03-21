package poker

import org.junit.Test

class PairsInHand {

    @Test
    fun two_card_with_same_value_make_a_pair() {
        combinations_of("A♡ A♢ 2♡ 2♢ 7♢") should_contains pairs("A♢ A♡", "2♡ 2♢")
        combinations_of("K♡ K♢ 2♡ 2♢ 7♢") should_contains pairs("K♢ K♡", "2♡ 2♢")
    }

    fun pairs(pair1: String, pair2: String): Combination {
        return Combination(
            Type.PAIRS
            , listOf(
                card(pair1.substringBefore(" ")),
                card(pair1.substringAfter(" ")),
                card(pair2.substringBefore(" ")),
                card(pair2.substringAfter(" "))
            )
        )

    }

}


