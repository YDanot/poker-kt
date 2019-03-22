package poker

import org.junit.Test
import poker.combination.Combination
import poker.combination.Type

class FullHouseInHand {

    @Test
    fun trips_plus_pair_make_a_fullhouse() {
        combinations_of("A♡ A♢ A♧ Q♡ Q♢") should_contains fullHouse("A♡ A♢ A♧ Q♡ Q♢")
    }

    private fun fullHouse(flush: String): Combination {
        return Combination(
            Type.FULLHOUSE, flush.split(" ").map { card(it) })
    }
}


