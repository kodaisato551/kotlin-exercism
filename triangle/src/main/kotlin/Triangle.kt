class Triangle(side1: Number, side2: Number, side3: Number) {
    val triangleSet = hashSetOf<Number>(side1, side2, side3)
    val isTriangle = (side1.toDouble() + side2.toDouble() > side3.toDouble() && side1.toDouble() + side3.toDouble() > side2.toDouble() && side2.toDouble() + side3.toDouble() > side1.toDouble())
            && (side1.toDouble() > 0.0 && side2.toDouble() > 0.0 && side3.toDouble() > 0.0)

    /**
     * Helper method
     * 1:正三角形
     * 2:二等辺三角形
     * 3:三角形
     */
    private fun calcuateTriangleType(equalSide: Int): Boolean {
        if (!isTriangle || triangleSet.size != equalSide) {
            return false
        }
        return true
    }

    //正三角形かどうか
    val isEquilateral: Boolean = calcuateTriangleType(1)

    //二等辺三角形かどうか
    val isIsosceles: Boolean = calcuateTriangleType(2)

    //三角形かどうか
    val isScalene: Boolean = calcuateTriangleType(3)

}
