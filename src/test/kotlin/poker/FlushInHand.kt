package poker

import org.junit.Test

class FlushInHand {

    @Test
    fun five_cards_with_same_color_make_a_flush() {
        combinations_of("A♡ K♡ 2♡ Q♡ J♡") should_contains flush("A♡ K♡ 2♡ Q♡ J♡")
    }

    private fun flush(flush: String): Combination {
        return Combination(
            Type.FLUSH, flush.split(" ").map { card(it) })
    }
}


