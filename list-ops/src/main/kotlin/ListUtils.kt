import java.util.stream.Collectors

fun <E> List<E>.customAppend(appendList: List<E>): List<E> {
    if (appendList.isEmpty()) return appendList
    val list = toMutableList()
    list.addAll(appendList)
    return list
}

fun <E> List<List<E>>.customConcat(): List<E> {
    if (this.isEmpty()) return emptyList()
    val list = this.toMutableList()
    return list.stream().flatMap { l -> l.stream() }.collect(Collectors.toList())
}

fun <E> List<E>.customFilter(function: (E) -> Boolean): List<E> {
    if (this.isEmpty()) return emptyList()
    val list = mutableListOf<E>()
    this.forEach {
        if (function(it)) {
            list.add(it)
        }
    }
    return list
}

val <E>List<E>.customSize: Int
    get() {
        var size = 0
        this.forEach { _ -> size++ }
        return size
    }

fun <E> List<E>.customMap(iterator: (E) -> E): List<E> {
    if (this.isEmpty()) return emptyList()
    val list = mutableListOf<E>()
    this.forEach {
        list.add(iterator(it))
    }
    return list
}

fun <E, R> List<E>.customFoldLeft(initial: R, operation: (R, E) -> R): R {
    var result: R = initial
    this.forEach {
        result = operation(result, it)
    }
    return result
}

fun <E, R> List<E>.customFoldRight(initial: R, operation: (E, R) -> R): R {
    var result: R = initial
    this.customReverse().forEach {
        result = operation(it, result)
    }
    return result
}

fun <E> List<E>.customReverse(): List<E> {
    if (this.isEmpty()) return emptyList()
    val list = this.toMutableList()
    return list.reversed()
}




