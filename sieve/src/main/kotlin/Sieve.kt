import kotlin.math.sqrt

object Sieve {
    fun primesUpTo(upperBound: Int): List<Int> {
        if (upperBound < 2) return emptyList()
        val searchList = (2..upperBound).toMutableList()
        val primeList = mutableListOf<Int>()
        var firstIndexedNum = searchList[0]
        while (firstIndexedNum < sqrt(upperBound.toDouble())) {
            primeList.add(firstIndexedNum)
            searchList.removeAll { num -> num % firstIndexedNum == 0 }
            firstIndexedNum = searchList[0]
        }
        primeList += searchList
        return primeList
    }
}
