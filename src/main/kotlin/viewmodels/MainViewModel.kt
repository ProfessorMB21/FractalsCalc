package viewmodels

import androidx.compose.ui.graphics.drawscope.DrawScope
import painting.FractalPainter
import painting.conversion.Plane

class MainViewModel {
    private val plane = Plane(-2.0, 1.0, -1.0, 1.0)
    private val fractalPainter = FractalPainter(plane)

    fun paint(scope: DrawScope) {
        fractalPainter.width = scope.size.width
        fractalPainter.height = scope.size.height
        fractalPainter.paint(scope)
    }
}