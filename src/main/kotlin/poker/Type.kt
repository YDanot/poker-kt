package poker

enum class Type {

    HIGHEST, PAIR, PAIRS, TRIPS;

    companion object {
        fun orderedTypes(): List<Type> {
            return listOf(TRIPS, PAIRS, PAIR, HIGHEST)
        }
    }
}
