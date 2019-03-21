package poker

enum class Type {

    HIGHEST, PAIR;

    companion object {
        fun orderedTypes(): List<Type> {
            return listOf(PAIR, HIGHEST)
        }
    }
}
