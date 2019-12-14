data class MatrixCoordinate(val row: Int, val col: Int)

class Matrix(val matrix: List<List<Int>>) {
    val saddlePoints: Set<MatrixCoordinate>
        get() {
            val result = mutableSetOf<MatrixCoordinate>()
            for (rownum in matrix.indices) {
                val row = matrix[rownum]
                val maxOfRow = row.max()
                //val minOfRow = row.min()
                for (colnum in row.indices) {
                    val minOfCol = matrix.map { it[colnum] }.min()
                    //val maxOfCol = matrix.map { it[colnum] }.max()
                    val elem = row[colnum]

                    if (elem == minOfCol && elem == maxOfRow) {
                        result.add(MatrixCoordinate(rownum + 1, colnum + 1))
                    }
//                    else if (elem == maxOfCol && elem == minOfRow) {
//                        result.add(MatrixCoordinate(rownum + 1, colnum + 1))
//                    }
                }
            }
            if (result.isEmpty()) {
                return emptySet()
            }

            return result
        }
}
