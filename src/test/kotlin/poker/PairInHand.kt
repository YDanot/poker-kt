package poker

import org.junit.Test

class PairInHand {

    @Test
    fun two_card_with_same_value_make_a_pair() {
        combinations_of("A♡ A♢ 2♢ 3♢ 7♢") should_contains pair("A♢ A♡")
        combinations_of("K♡ K♢ 2♢ 3♢ 7♢") should_contains pair("K♢ K♡")
    }

    fun pair(pair: String): Combination {
        return Combination(
            Type.PAIR, listOf(
                card(pair.substringBefore(" ")),
                card(pair.substringAfter(" "))
            )
        )
    }
}


