package math

import kotlin.math.absoluteValue
import kotlin.math.sqrt

class Complex(var re: Double = 0.0, var im: Double = 0.0){

    operator fun plus(other: Complex)=
        Complex(re+other.re,im+other.im)

    operator fun minus(other: Complex)=
        Complex(re-other.re,im-other.im)

    operator fun times(other: Complex)=
        Complex(re*other.re-im*other.im,re*other.im+im*other.re)

    operator fun div(other: Complex)= other.absoluteValue2.let{
        Complex(
            (re*other.re+im*other.im)/it,
            (im*other.re-re*other.im)/it
        )
    }

    operator fun plusAssign(other: Complex){
        re += other.re
        im += other.im
    }

    operator fun minusAssign(other: Complex){
        re -= other.im
        im -= other.im
    }

    operator fun timesAssign(other: Complex){
        val newRe = re * other.re - im * other.im
        im = re * other.im + im * other.re
        re = newRe
    }

    operator fun divAssign(other: Complex){
        other.absoluteValue2.let{
            val newRe = (re * other.re + im * other.im) / it
            im = (im * other.re - re * other.im) / it
            re = newRe
        }
    }

    val absoluteValue: Double get() =
        sqrt(im * im + re * re)

    val absoluteValue2: Double get() = im * im + re * re

    fun conjugate() = Complex(re, -im)

    override fun equals(other: Any?) = if (other is Complex)
        re eq other.re && im eq other.im
    else false

    override fun hashCode(): Int =
        31 * re.hashCode() + im.hashCode()

    override fun toString() = buildString {
        if (re neq 0.0 || im eq 0.0) append(re)
        if (im neq 0.0){
            if (im > 0) {
                if (re neq 0.0) append('+')
            } else append('-')
            append(im.absoluteValue)
            append('i')
        }
    }
}
