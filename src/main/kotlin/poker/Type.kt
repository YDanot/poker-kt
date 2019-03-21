package poker

enum class Type {

    HIGHEST, PAIR, PAIRS;

    companion object {
        fun orderedTypes(): List<Type> {
            return listOf(PAIRS, PAIR, HIGHEST)
        }
    }
}
