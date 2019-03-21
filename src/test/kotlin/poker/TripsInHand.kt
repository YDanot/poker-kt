package poker

import org.junit.Test

class TripsInHand {

    @Test
    fun three_cards_with_same_value_make_a_trips() {
        combinations_of("A♡ A♢ A♧ 2♢ 7♢") should_contains trips("A♢ A♡ A♧")
        combinations_of("K♡ K♢ K♧ 2♢ 7♢") should_contains trips("K♢ K♡ K♧")
    }

    fun trips(trips: String): Combination {
        return Combination(
            Type.TRIPS, trips.split(" ").map { card(it) })
    }
}


