package poker

import org.junit.Test

class HandComparison {

    @Test
    fun draw() = "K♧ 6♧ 2♧ 3♧ 7♤" should_be_equals_to "K♡ 6♡ 2♡ 3♢ 7♡"

    @Test
    fun higher_card_wins_when_no_combination_on_both_hands() {
        "K♡ 10♡ 9♢ 8♢ 2♢" should_win_against "Q♢ 10♢ 9♡ 8♡ 2♡"
    }

    @Test
    fun pair_wins_against_no_combination() {
        "10♡ 9♢ 8♢ 2♡ 2♢" should_win_against "Q♢ 10♢ 9♡ 8♡ 3♡"
    }

    @Test
    fun highest_pair_wins() {
        "10♡ 10♢ 8♢ 3♡ 2♢" should_loose_against "Q♢ J♢ J♡ 8♡ 3♡"
        "K♡ K♢ 8♢ 3♡ 2♢" should_win_against "Q♢ J♢ J♡ 8♡ 3♡"
    }

    @Test
    fun pairs_wins_against_single_pair() {
        "10♡ 10♢ 8♢ 8♡ 2♢" should_win_against "Q♢ Q♡ 9♡ 8♡ 3♡"
    }

    @Test
    fun pairs_with_the_highest_pair_wins() {
        "10♡ 10♢ 8♢ 8♡ 2♢" should_loose_against "Q♢ Q♡ 9♡ 9♡ 3♡"
        "10♡ 10♢ 8♢ 8♡ 4♢" should_win_against "10♧ 10♤ 8♧ 8♤ 2♧"
    }

    @Test
    fun highest_card_win_when_pairs_equals() {
        "10♡ 10♢ 8♢ 8♡ 4♢" should_win_against "10♧ 10♤ 8♧ 8♤ 2♧"
    }

    @Test
    fun trips_wins_against_pairs() {
        "A♡ A♢ 10♤ 10♡ 2♢" should_loose_against "Q♢ Q♡ Q♤ 8♡ 3♡"
        "10♡ 9♢ 2♤ 2♡ 2♢" should_win_against "Q♢ Q♡ 9♡ 9♢ 3♡"
    }

    @Test
    fun highest_trips_wins() {
        "10♡ 10♢ 10♤ 3♡ 2♢" should_loose_against "J♤ J♢ J♡ 8♡ 3♡"
        "K♡ K♢ K♤ 3♡ 2♢" should_win_against "J♤ J♢ J♡ 8♡ 3♡"
    }

    @Test
    fun straight_wins_against_trips() {
        "A♡ K♢ 10♤ Q♡ J♢" should_win_against "Q♢ Q♡ Q♤ 8♡ 3♡"
        "Q♢ Q♡ Q♤ 8♡ 3♡" should_loose_against "A♡ K♢ 10♤ Q♡ J♢"
    }

    @Test
    fun highest_straight_wins() {
        "A♡ K♢ 10♤ Q♡ J♢" should_win_against "K♢ Q♡ J♤ 9♡ 10♡"
        "K♢ Q♡ J♤ 9♡ 10♡" should_loose_against "A♡ K♢ 10♤ Q♡ J♢"
    }

    @Test
    fun flush_wins_against_straight() {
        "K♡ Q♡ 10♡ J♡ 7♡" should_win_against "A♡ K♢ Q♤ J♡ 10♢"
        "A♡ K♢ Q♤ J♡ 10♢" should_loose_against "K♡ Q♡ 10♡ J♡ 7♡"
    }

    @Test
    fun highest_flush_wins() {
        "K♡ Q♡ 10♡ J♡ 7♡" should_win_against "2♡ Q♡ 10♡ J♡ 7♡"
        "2♡ Q♡ 10♡ J♡ 7♡" should_loose_against "K♡ Q♡ 10♡ J♡ 7♡"
    }

    @Test
    fun full_wins_against_flush() {
        "K♡ K♢ K♤ 8♢ 8♢" should_win_against "A♡ K♡ Q♡ J♡ 9♡"
        "A♡ K♡ Q♡ J♡ 9♡" should_loose_against "K♡ K♢ K♤ 8♢ 8♢"
    }

    @Test
    fun highest_full_wins() {
        "K♡ K♢ K♤ 8♢ 8♢" should_win_against "Q♡ Q♢ Q♤ A♢ A♢"
        "Q♡ Q♢ Q♤ A♢ A♢" should_loose_against "K♡ K♢ K♤ 8♢ 8♢"
    }

    @Test
    fun quads_wins_against_full_house() {
        "Q♢ Q♡ Q♤ Q♧ 3♡" should_win_against "A♡ A♢ 10♤ 9♡ 2♢"
        "A♡ A♢ 10♤ 9♡ 2♢" should_loose_against "Q♢ Q♡ Q♤ Q♧ 3♡"
    }

    @Test
    fun highest_quads_wins() {
        "J♤ J♢ J♡ J♧ 3♡" should_win_against "10♡ 10♢ 10♤ 10♧ 2♢"
        "10♡ 10♢ 10♤ 10♧ 2♢" should_loose_against "J♤ J♢ J♡ J♧ 3♡"
    }

    @Test
    fun straight_flush_wins_against_quads() {
        "A♡ K♡ 10♡ Q♡ J♡" should_win_against "Q♢ Q♡ Q♤ Q♧ 3♡"
        "Q♢ Q♡ Q♤ Q♧ 3♡" should_loose_against "A♡ K♡ 10♡ Q♡ J♡"
    }

    @Test
    fun highest_straight_flush_wins() {
        "A♡ K♡ 10♡ Q♡ J♡" should_win_against "K♧ Q♧ J♧ 9♧ 10♧" 
        "K♧ Q♧ J♧ 9♧ 10♧" should_loose_against "A♡ K♡ 10♡ Q♡ J♡" 
    }
    
}
