class Reactor<T>() {
    // Your compute cell's addCallback method must return an object
    // that implements the Subscription interface.
    interface Subscription {
        fun cancel()
    }

    abstract inner class Cell {
        abstract val value: T
        internal val dependents = mutableListOf<ComputeCell>()
    }


    inner class InputCell(input: T) {
        override var value: T
    }

    inner class ComputeCell(vararg inputCell: Cell, f: (List<T>) -> Unit, override val value: T) : Cell() {
        fun addCallback(function: (T) -> Unit): Subscription {
        }
    }

}
