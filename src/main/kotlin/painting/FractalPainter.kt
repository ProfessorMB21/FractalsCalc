package painting

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import fractal.Mandelbrot
import math.Complex
import painting.conversion.Converter
import painting.conversion.Plane

class FractalPainter(private val plane: Plane) : Painter {
    override var width: Float
        get() = plane.width
        set(value){
            plane.width = value
        }

    override var height: Float
        get() = plane.height
        set(value){
            plane.height = value
        }

    override fun paint(scope: DrawScope) {
        val m = Mandelbrot()
        repeat(width.toInt()){ iX ->
            val x = iX.toFloat()
            repeat(height.toInt()){ iY ->
                val y = iY.toFloat()
                scope.drawRect(
                    if (m.isInSet(Complex(
                            Converter.xScr2Crt(x, plane),
                            Converter.yScr2Crt(y, plane),
                    ))) Color.Red else Color.White,
                    Offset(x, y),
                    Size(1f, 1f),
                )
            }
        }
    }
}
