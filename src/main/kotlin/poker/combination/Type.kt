package poker.combination

import poker.card.Card


enum class Type {

    HIGHEST {
        override fun find(cards: List<Card>): Combination? {
            return highest(cards)
        }
    },
    PAIR {
        override fun find(cards: List<Card>): Combination? {
            return pair(cards)
        }
    },
    PAIRS {
        override fun find(cards: List<Card>): Combination? {
            return pairs(cards)
        }
    },
    TRIPS {
        override fun find(cards: List<Card>): Combination? {
            return trips(cards)
        }
    },
    STRAIGHT {
        override fun find(cards: List<Card>): Combination? {
            return straight(cards)
        }
    },
    FLUSH {
        override fun find(cards: List<Card>): Combination? {
            return flush(cards)
        }
    },
    FULLHOUSE {
        override fun find(cards: List<Card>): Combination? {
            return fullHouse(cards)
        }
    },
    QUADS {
        override fun find(cards: List<Card>): Combination? {
            return quads(cards)
        }
    },
    STRAIGHT_FLUSH {
        override fun find(cards: List<Card>): Combination? {
            return straightFlush(cards)
        }
    };

    abstract fun find(cards:List<Card>):Combination?
}
