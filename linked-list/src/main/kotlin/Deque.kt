class Deque<E> {

    var size: Int = 0
    var first: Node<E>? = null


    //後ろに値を入れる
    fun push(element: E) {
        if (first == null) {
            first = Node<E>(element, null)
        } else {
            this.get(size).next = Node<E>(element, null)
        }
        size++
    }

    //後ろの値を削除
    fun pop() {
        this.get(size - 1).next = null
        size--
    }

    //前の値を削除
    fun shift() {
        first = first.next
        size--
    }

    //値を先頭に挿入します
    fun unshift(element: E) {
        if (first == null) {
            first = Node<E>(element, null)
        } else {
            this.first = Node<E>(element, this.first)
        }
        size++
    }

    //indexを指定して
    private fun get(index: Int): Node<E>? {
        var current: Node<E>? = first
        for (i in 1..index) {
            current = current.next
        }
        return current
    }


}

class Node<E>(var item: E, var next: Node<E>?) {

}
