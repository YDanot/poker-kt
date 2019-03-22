package poker.combination

import poker.card.Card


enum class Type {

    HIGHEST {
        override fun findIn(cards: List<Card>): Combination? {
            return highest(cards)
        }
    },
    PAIR {
        override fun findIn(cards: List<Card>): Combination? {
            return pair(cards)
        }
    },
    PAIRS {
        override fun findIn(cards: List<Card>): Combination? {
            return pairs(cards)
        }
    },
    TRIPS {
        override fun findIn(cards: List<Card>): Combination? {
            return trips(cards)
        }
    },
    STRAIGHT {
        override fun findIn(cards: List<Card>): Combination? {
            return straight(cards)
        }
    },
    FLUSH {
        override fun findIn(cards: List<Card>): Combination? {
            return flush(cards)
        }
    },
    FULLHOUSE {
        override fun findIn(cards: List<Card>): Combination? {
            return fullHouse(cards)
        }
    },
    QUADS {
        override fun findIn(cards: List<Card>): Combination? {
            return quads(cards)
        }
    },
    STRAIGHT_FLUSH {
        override fun findIn(cards: List<Card>): Combination? {
            return straightFlush(cards)
        }
    };

    abstract fun findIn(cards:List<Card>):Combination?
}
