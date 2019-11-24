import java.util.Collections;

enum class Signal(val bycode: Int) {
    WINK(0b1), DOUBLE_BLINK(0b10), CLOSE_YOUR_EYES(0b100), JUMP(0b1000)

}

object HandshakeCalculator {
    fun calculateHandshake(input: Int): List<Signal> {
        if (input <= 0 || input > 31) return emptyList()

        var list = mutableListOf<Signal>()
        for (value in Signal.values()) {
            if (isContain(input, value.bycode)) {
                list.add(value)
            }
        }

        if (isContain(input, 0b10000)) {
            Collections.reverse(list)
        }

        return list
    }

    /**
     * インプットの値がenumに含まれているかをどうかを返します
     */
    fun isContain(input: Int, bycode: Int): Boolean {
        return (input and bycode) == bycode
    }


}

