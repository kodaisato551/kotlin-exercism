import kotlin.math.min

/**
 * https://qiita.com/drken/items/ace3142967c4f01d42e9#%E5%80%8B%E6%95%B0%E5%88%B6%E9%99%90%E3%81%AA%E3%81%97%E3%83%8A%E3%83%83%E3%83%97%E3%82%B5%E3%83%83%E3%82%AF
 */
class ChangeCalculator3(val coinList: List<Int>) {
    companion object {
        val INF = Int.MAX_VALUE
    }

    fun computeMostEfficientChange(totalAmount: Int): List<Int> {
        val size: Int = coinList.size
        var dp = Array(size + 1, { arrayOfNulls<Int>(totalAmount + 1) })
        //inicialize
        for (i in 0 until size + 1) {
            for (w in 0..totalAmount) {
                if (w == 0) {
                    dp[i][w] = 0
                } else {
                    dp[i][w] = INF
                }
            }
        }

        for (i in 0 until size) {
            for (w in 0..totalAmount) {
                dp[i + 1][w] = dp[i][w]?.let { dp[i + 1][w]?.let { it1 -> min(it1, it) } }
                if (w >= coinList[i]) {
                    dp[i + 1][w] =
                        dp[i + 1][w]?.let { dp[i + 1][w - coinList[i]]?.plus(1)?.let { it1 -> min(it, it1) } }

                } else {

                }

            }
        }
        println()

        for (i in 0 until size + 1) {
            for (w in 0..totalAmount) {
                print("${dp[i][w]} ")
            }
            println()
        }

        return emptyList()
    }


}

fun main(args: Array<String>) {
    val computedChange = ChangeCalculator(listOf(1, 5, 10, 25, 100)).computeMostEfficientChange(26)
}