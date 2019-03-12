package poker

import poker.Color.DIAMOND
import poker.Color.HEART
import poker.Value.*

enum class Card(val color: Color, val value: Value) {

    HA(HEART, ACE), DA(DIAMOND, ACE),
    HK(HEART, KING),
    HQ(HEART, QUEEN),
    HJ(HEART, JACK),
    H10(HEART, TEN),
    H9(HEART, NINE),
    H8(HEART, EIGHT),
    H7(HEART, SEVEN),
    H6(HEART, SIX),
    H5(HEART, FIVE),
    H4(HEART, FOUR),
    H3(HEART, THREE),
    H2(HEART, TWO),


}
