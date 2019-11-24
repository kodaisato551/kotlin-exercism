class ChangeCalculator2(val coinList: List<Int>) {

    fun computeMostEfficientChange(totalAmount: Int): List<Int> {

        require(totalAmount >= 0) { "Negative totals are not allowed." }
        if (totalAmount == 0) return emptyList()
        var count: Int
        //払い方のリスト
        val payList = mutableListOf<MutableMap<Int, Int>>()
        var amount = totalAmount
        val remainingCoinList: MutableList<Int> = coinList.sortedDescending().map { it }.toMutableList()
        while (remainingCoinList.isNotEmpty()) {
            val map = mutableMapOf<Int, Int>()
            amount = totalAmount
            for (coin in remainingCoinList) {
                count = amount / coin
                if (count == 0) break
                map[coin] = count
                amount %= coin
                if (amount == 0) break
            }
            if (amount == 0) {
                payList.add(map)
            }
            remainingCoinList.removeAt(0)
        }
        val minPayTime = findMinPayTimes(payList)
        require(minPayTime.isNotEmpty()) { "The total $totalAmount cannot be represented in the given currency." }
        println(payList)
        return minPayTime

    }

    private fun findMinPayTimes(payList: MutableList<MutableMap<Int, Int>>): List<Int> {
        var min = Int.MAX_VALUE
        var sum: Int
        var minID = -1
        for (i in 0 until payList.size) {
            if (payList[i].isEmpty()) continue
            sum = payList[i].values.sum()
            if (min > sum) {
                min = sum
                minID = i
            }
        }
        return if (minID >= 0) {
            return convertToList(payList[minID])
        } else {
            emptyList()
        }
    }

    private fun convertToList(map: Map<Int, Int>): List<Int> {
        println("mapper : $map")
        val list = mutableListOf<Int>()
        for (key in map.keys) {
            val count: Int? = map[key]
            println("key $key count $count")
            for (e in 0 until count!!) {
                list.add(key)
            }
        }
        println(list)
        return list.sorted()
    }
}


fun main(args: Array<String>) {
    ChangeCalculator2(listOf(1, 5, 10, 25, 100)).computeMostEfficientChange(135)
}