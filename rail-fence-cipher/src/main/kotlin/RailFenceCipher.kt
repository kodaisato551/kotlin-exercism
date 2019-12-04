class RailFenceCipher(val layerNum: Int) {


    fun getEncryptedData(input: String): String {
        val map: MutableMap<Int, MutableList<Char>> = mutableMapOf()
        for (i in input.indices) {
            

            if (map[i % layerNum].isNullOrEmpty()) {
                map[i % layerNum] = mutableListOf()
            }

            map[i % layerNum]?.add(input[i])
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
        TODO("Implement this function to complete the task")
    }


}
