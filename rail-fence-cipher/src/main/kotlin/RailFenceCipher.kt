class RailFenceCipher(val layerNum: Int) {


    fun getEncryptedData(input: String): String {
        val map: MutableMap<Int, MutableList<Char>> = mutableMapOf()
        var index = 0
        for (i in input.indices) {
            if (map[index] == null) {
                map[index] = mutableListOf()
            }
            map[index]?.add(input[i])

            if (i / (layerNum - 1) % 2 == 0) {
                index++
            } else {
                index--
            }
        }
        var result = ""
        for (i in 0..map.size - 1) {
            if (!map[i].isNullOrEmpty()) {
                result += map[i]?.joinToString("")
            }
        }
        return result
    }

    fun getDecryptedData(input: String): String {
        val indexTransision = mutableListOf<Int>()
        for (diff in 0..(layerNum - 1)) {
            var by = 0
            while (true) {
                if (by == 0) {
                    indexTransision.add(diff)
                    by += 2
                    continue
                }

                if (by * (layerNum - 1) - diff > input.length - 1) {
                    break
                }
                if (diff != (layerNum - 1)) {
                    indexTransision.add(by * (layerNum - 1) - diff)
                }

                if (by * (layerNum - 1) + diff > input.length - 1) {
                    break
                }
                if (diff != 0) {
                    indexTransision.add(by * (layerNum - 1) + diff)
                }
                by += 2
            }

        }
        val result = Array(input.length) { ' ' }
        for (i in input.indices) {
            result[indexTransision[i]] = input[i]
        }
        return result.joinToString("")
    }

}
