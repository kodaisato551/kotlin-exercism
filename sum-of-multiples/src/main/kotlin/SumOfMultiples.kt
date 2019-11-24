object SumOfMultiples {
    fun sum(multiSet: Set<Int>, max: Int): Int {
        val numericSet = hashSetOf<Int>()
        for (i in 1..max) {
            for (j in multiSet) {
                if (i * j <= max) {
                    numericSet.add(i * j)
                }
            }
        }
        return numericSet.size
    }


}
