import java.util.*

class Anagram(private val inputString: String) {

    fun match(words: List<String>): Set<String> {
        val result: MutableSet<String> = mutableSetOf()
        for (word: String in words) {
            if (isAnagram(inputString, word)) {
                result.add(word)
            }
        }
        return if (result.isEmpty()) emptySet() else result
    }

    /**
     * 第一引数が第二引数のアナグラムかであればtrue、そうでないければfalse
     */
    private fun isAnagram(inputString: String, word: String): Boolean {
        if (inputString.length != word.length) return false
        if (isUpperCaseOfAnagram(inputString, word)) return false
        return alphabetize(inputString) == alphabetize(word)
    }

    /**
     * Stringをアルファベット順にソートする
     * ※すべて小文字化されたStringが返される
     */
    private fun alphabetize(s: String): String {
        val a: CharArray = s.toLowerCase().toCharArray()
        Arrays.sort(a)
        return String(a)
    }

    /**
     * 大文字のアナグラムでかつ比較するwordが同一の綴りだった場合Trueを返す
     * ex)
     * inputString : BANANA
     * word : Banana
     * （このケースはAnagramではない判定とする）
     */
    private fun isUpperCaseOfAnagram(str: String, word: String): Boolean {
        return word.toUpperCase() == str
    }

}