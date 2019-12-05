import kotlin.math.abs

class RailFenceCipher(val layerNum: Int) {


    fun getEncryptedData(input: String): String {
        val map: MutableMap<Int, MutableList<Char>> = mutableMapOf()
        var index = 0
        var count = 0
        for (i in input.indices) {

            if (i % layerNum == 0) {
                count++
            }

            index = -abs(i - count * (layerNum - 1)) + (layerNum - 1)
            println(index)
            if (map[index].isNullOrEmpty()) {
                map[index] = mutableListOf()
            }

            map[index]?.add(input[i])


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
