import java.lang.Math

object Prime {

    fun nth(intger: Int): Int {
        if (intger == 0) {
            throw IllegalArgumentException("There is no zeroth prime.")
        }

        var list = mutableListOf<Int>(2)
        var num: Int = 2

        do {
            if (isPrime(num)) {
                list.add(num)
            }
            num = num + 1
        } while (list.size <= intger)

        return list.get(list.size - 1)
    }

    /**
     * 素数判定
     */
    fun isPrime(num: Int): Boolean {
        if (num < 2) return false;
        else if (num == 2) return true;
        else if (num % 2 == 0) return false; // 偶数はあらかじめ除く

        val sqrtNum = Math.sqrt(num.toDouble())

        for (i in 3..sqrtNum.toInt() step 2) {
            if (num % i == 0) {
                return false
            }
        }
        return true
    }
}