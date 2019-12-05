object BinarySearch {
    fun search(list: List<Int>, item: Int): Int {
        return baseSearch(list, item, 0, list.size - 1)
    }

    private fun baseSearch(list: List<Int>, item: Int, imin: Int, imax: Int): Int {
        if (imax < imin)
            throw NoSuchElementException("element not found")

        val imid: Int = (imin + imax) / 2
        return when {
            list[imid] > item -> {
                baseSearch(list, item, imin, imid - 1)
            }
            list[imid] < item -> {
                baseSearch(list, item, imid + 1, imax)
            }
            else -> {
                imid
            }
        }


    }

}
