import kotlin.math.cos
import kotlin.math.exp
import kotlin.math.sin
import kotlin.math.sqrt

data class ComplexNumber(val real: Double = 0.0, val imag: Double = 0.0) {
    val sumOfSquare = real * real + imag * imag
    val abs = sqrt(sumOfSquare)
}

operator fun ComplexNumber.times(complexNumber: ComplexNumber): ComplexNumber {
    val real = this.real * complexNumber.real - this.imag * complexNumber.imag
    val imag = this.imag * complexNumber.real + this.real * complexNumber.imag
    return ComplexNumber(real, imag)
}

operator fun ComplexNumber.plus(complexNumber: ComplexNumber): ComplexNumber {
    val real = this.real + complexNumber.real
    val imag = this.imag + complexNumber.imag
    return ComplexNumber(real, imag)
}

operator fun ComplexNumber.div(complexNumber: ComplexNumber): ComplexNumber {
    val real = this.real * complexNumber.real + this.imag * complexNumber.imag
    val imag = this.imag * complexNumber.real - this.real * complexNumber.imag
    return ComplexNumber(real / complexNumber.sumOfSquare, imag / complexNumber.sumOfSquare)
}

operator fun ComplexNumber.minus(complexNumber: ComplexNumber): ComplexNumber {
    val real = this.real - complexNumber.real
    val imag = this.imag - complexNumber.imag
    return ComplexNumber(real, imag)
}

fun exponential(complexNumber: ComplexNumber): ComplexNumber {
    val real = exp(complexNumber.real) * cos(complexNumber.imag)
    val imag = exp(complexNumber.real) * sin(complexNumber.imag)
    return ComplexNumber(real, imag)
}

fun ComplexNumber.conjugate(): ComplexNumber {
    return ComplexNumber(this.real, -this.imag)
}


