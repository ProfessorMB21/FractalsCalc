package math

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.ulp

fun Double.eq(other: Double, eps: Double) = abs(this - other) < eps
infix fun Double.eq(other: Double) = abs(this - other) < max(ulp, other.ulp) * 10
fun Double.neq(other: Double, eps: Double) = !eq(other, eps)
infix fun Double.neq(other: Double) = !(this eq other)
