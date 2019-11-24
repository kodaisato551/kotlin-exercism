object Pangram {
    fun isPangram(str: String): Boolean {
        for (chr in 'a'..'z') {
            if (!str.contains(chr)) {
                return false
            }
        }
        return true
    }
}




