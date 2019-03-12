package poker

import org.assertj.core.api.Assertions
import org.junit.Test
import poker.Card.*


class CardComparisonTest {

    @Test fun ace_should_be_higher_than_king()    = HA.should_be_higher_than(HK)
    @Test fun king_should_be_higher_than_queen()  = HK.should_be_higher_than(HQ)
    @Test fun queen_should_be_higher_than_jack()  = HQ.should_be_higher_than(HJ)
    @Test fun jack_should_be_higher_than_ten()    = HJ.should_be_higher_than(H10)
    @Test fun ten_should_be_higher_than_nine()    = H10.should_be_higher_than(H9)
    @Test fun nine_should_be_higher_than_eight()  = H9.should_be_higher_than(H8)
    @Test fun eight_should_be_higher_than_seven() = H8.should_be_higher_than(H7)
    @Test fun seven_should_be_higher_than_six()   = H7.should_be_higher_than(H6)
    @Test fun six_should_be_higher_than_five()    = H6.should_be_higher_than(H5)
    @Test fun five_should_be_higher_than_four()   = H5.should_be_higher_than(H4)
    @Test fun four_should_be_higher_than_three()  = H4.should_be_higher_than(H3)
    @Test fun three_should_be_higher_than_two()   = H3.should_be_higher_than(H2)
    @Test fun color_should_not_be_valuable()      = HA.should_be_equal_to(DA)

    private fun Card.should_be_higher_than(other: Card) {
        Assertions.assertThat(this.value).isGreaterThan(other.value);
    }
    private fun Card.should_be_equal_to(other: Card) {
        Assertions.assertThat(this.value).isEqualByComparingTo(other.value);
    }


}





