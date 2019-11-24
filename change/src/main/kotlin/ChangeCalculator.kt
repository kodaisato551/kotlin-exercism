class ChangeCalculator(val coinList: List<Int>) {
    fun computeMostEfficientChange(totalAmount: Int): List<Int> {
        require(totalAmount >= 0) { "Negative totals are not allowed." }
        val dp = Array<List<Int>?>(totalAmount + 1) { null }
        dp[0] = emptyList()
        for (coin in coinList.sortedDescending()) {
            for (j in coin..totalAmount) {
                if (dp[j - coin] == null) {
                    continue
                }
                val current = dp[j]
                //!! may be ok because null check done
                if (current == null || current.size > dp[j - coin]!!.size + 1) {
                    dp[j] = dp[j - coin]!!.plus(coin)
                }
            }
        }
        val result = dp[totalAmount]
        require(result != null) {
            "The total $totalAmount cannot be represented in the given currency."
        }
        return result!!.sorted()
    }
}