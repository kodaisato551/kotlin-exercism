enum class Relationship {

    EQUAL, SUBLIST, SUPERLIST, UNEQUAL

}

fun <E> List<E>.relationshipTo(other: List<E>): Relationship = when {
    this == other -> Relationship.EQUAL
    this.isSublistOf(other) -> Relationship.SUBLIST
    other.isSublistOf(this) -> Relationship.SUPERLIST
    else -> Relationship.UNEQUAL
}

private fun <E> List<E>.isSublistOf(other: List<E>): Boolean {
    if (this.isEmpty()) return true
    if (this.size > other.size) return false
    for (i in 0 .. (other.size-1)){
        val tmp_size = i + this.size
        if(tmp_size > other.size) continue
        if(other.subList(i,tmp_size) == this){
            return true
        }
    }
    return false
}