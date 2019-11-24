import java.util.stream.Collectors.toList


class MinesweeperBoard(private var inputBoard: List<String>) {
    private var board: MutableList<String> = mutableListOf()
    private var colSize: Int = if (inputBoard.isEmpty()) {
        0
    } else {
        inputBoard[0].length
    }

    private var rowSize: Int = if (inputBoard.isEmpty()) {
        0
    } else {
        inputBoard.size
    }

    fun withNumbers(): List<String> {

        if (inputBoard.isEmpty() || inputBoard == listOf("")) {
            return inputBoard
        }

        val binaryMatrix = Array(rowSize) { IntArray(colSize) }

        var isContainAster = false

        //アスタリスクの箇所に１をとりをそれ以外は０のマトリクスを生成する
        for ((i, str) in inputBoard.withIndex()) {
            if (str.contains("*")) {
                isContainAster = true
                for (j in 0 until colSize) {
                    if (str[j] == '*') {
                        binaryMatrix[i][j] = 1
                    }
                }
            }
        }

        if (!isContainAster) return inputBoard


        for (i in 0 until rowSize) {
            val sb = StringBuilder()
            for (j in 0 until colSize) {
                var sum = 0
                if (binaryMatrix[i][j] == 1) {
                    sb.append("*")
                    continue
                }
                val iList: List<Int> =
                    arrayListOf(i - 1, i, i + 1).stream().filter(isRowNotIndexOutOfBounds).collect(toList())
                val jList: List<Int> =
                    arrayListOf(j - 1, j, j + 1).stream().filter(isColNotIndexOutOfBounds).collect(toList())

                //中身は明らかにInt(だと思う）なので!!
                for (l in iList) for (m in jList) {
                    sum += binaryMatrix[l][m]
                }

                if (sum == 0) {
                    sb.append(" ")
                } else {
                    sb.append(sum.toString())
                }
            }

            board.add(sb.toString())
        }

        return board
    }

    /**
     * 配列のsize内に収まっていたらTrue
     */
    private val isRowNotIndexOutOfBounds: (Int) -> Boolean = { i: Int -> (i in 0 until rowSize) }

    private val isColNotIndexOutOfBounds: (Int) -> Boolean = { i: Int -> (i in 0 until colSize) }


}
