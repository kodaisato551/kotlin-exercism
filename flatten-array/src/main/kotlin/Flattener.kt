object Flattener {
    fun flatten(list: List<*>): List<*> {
        return list.flatMap { element ->
            when (element) {
                is List<*> -> flatten(element)
                else -> listOf(element)
            }
        }.filterNotNull()
    }
}