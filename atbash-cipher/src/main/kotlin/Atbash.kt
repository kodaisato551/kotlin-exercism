object Atbash {
    private val REVERSE_LETTER = ('a'..'z').toList().reversed()
    fun encode(plainText: String): String = convert(plainText).chunked(5).joinToString(" ")
    fun decode(secretText: String): String = convert(secretText)
    private fun convert(input: String): String {
        return input.toLowerCase().filter {
            it in '0'..'9' || it in 'a'..'z'
        }.map {
            when (it) {
                in 'a'..'z' -> REVERSE_LETTER[it - 'a']
                else -> it
            }
        }.joinToString("")
    }
}