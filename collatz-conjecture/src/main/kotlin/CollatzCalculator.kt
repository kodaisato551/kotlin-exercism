object CollatzCalculator {
    fun computeStepCount(num: Int): Int {
        require(num > 0) { "Only natural numbers are allowed." }
        var result = num
        var count = 0;
        while (result != 1) {
            if (result % 2 == 0) {
                result /= 2
            } else {
                result = 3 * result + 1
            }
            count++;
        }
        return count;
    }
}