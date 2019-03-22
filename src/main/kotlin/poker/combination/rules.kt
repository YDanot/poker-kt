package poker.combination

import poker.card.Card

fun highest(cards: List<Card>) = Combination(Type.HIGHEST, listOfNotNull(cards.max()))

fun pair(cards: List<Card>): Combination? {
    val pairsValue = cards.groupingBy { it.value }.eachCount().filter { it.value == 2 }.keys
    return if (pairsValue.size == 1) {
        Combination(
            Type.PAIR,
            cards.filter { it.value == pairsValue.first() }
        )
    } else {
        null
    }
}

fun pairs(cards: List<Card>): Combination? {
    val pairsValue = cards.groupingBy { it.value }.eachCount().filter { it.value == 2 }.keys
    return if (pairsValue.size == 2) {
        Combination(
            Type.PAIRS,
            cards.filter { pairsValue.contains(it.value) }
        )
    } else {
        null
    }
}

fun trips(cards: List<Card>): Combination? {
    val pairsValue = cards.groupingBy { it.value }.eachCount().filter { it.value == 3 }.keys
    return if (pairsValue.isNotEmpty()) {
        Combination(
            Type.TRIPS,
            cards.filter { it.value == pairsValue.first() }
        )
    } else {
        null
    }
}

fun straight(cards: List<Card>): Combination? {
    val sorted = cards.distinctBy { it.value }.sortedDescending()

    return if (sorted.first() - sorted.last() == sorted.size - 1) {
        Combination(
            Type.STRAIGHT,
            sorted.take(5)
        )
    } else {
        null
    }
}

private operator fun Card.minus(other: Card): Int {
    return this.value.ordinal - other.value.ordinal
}

fun flush(cards: List<Card>): Combination? {
    val flush = cards.groupingBy { it.color }.eachCount().filter { it.value >= 5 }.keys

    return if (flush.isNotEmpty()) {
        Combination(
            Type.FLUSH,
            cards.filter { it.color == flush.first() }.sorted().take(5)
        )
    } else {
        null
    }
}

fun fullHouse(cards: List<Card>): Combination? {

    val trips = trips(cards)
    val pair = pair(cards)

    return if (trips != null && pair != null) {
        Combination(
            Type.FULLHOUSE,
            trips.cards + pair.cards
        )
    } else {
        null
    }
}

fun quads(cards: List<Card>): Combination? {
    val pairsValue = cards.groupingBy { it.value }.eachCount().filter { it.value == 4 }.keys
    return if (pairsValue.isNotEmpty()) {
        Combination(
            Type.QUADS,
            cards.filter { it.value == pairsValue.first() }
        )
    } else {
        null
    }
}

fun straightFlush(cards: List<Card>): Combination? {
    val straight = straight(cards)
    val flush = when {
        straight == null -> null
        else -> flush(straight.cards)
    }

    return if (flush != null) {
        Combination(
            Type.STRAIGHT_FLUSH,
            flush.cards
        )
    } else {
        null
    }
}