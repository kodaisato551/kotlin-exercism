object Luhn {
    fun isValid(numbers: String): Boolean {
        val input = numbers.replace(Regex("\\s"), "").reversed()
        println(input)
        if (input.length <= 1) {
            return false
        }
        var sum = 0
        input.forEachIndexed() { index, c ->
            try {
                var value: Int = Character.getNumericValue(c)
                if ((index + 1) % 2 == 0) value *= 2
                if (value > 9) value -= 9
                sum += value
            } catch (e: NumberFormatException) {
                return false
            }
        }
        println(sum)
        return sum % 10 == 0
    }

}