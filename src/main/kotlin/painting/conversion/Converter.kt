package painting.conversion

object Converter {
    fun xCrt2Scr(x: Double, p: Plane) =
        ((x - p.xMin) * p.xDen).toFloat().coerceIn(-p.width..p.width*2f)

    fun yCrt2Scr(y: Double, p: Plane) =
        ((p.yMax - y) * p.yDen).toFloat().coerceIn(-p.height..p.height*2f)

    fun xScr2Crt(x: Float, p: Plane) =
        x / p.xDen + p.xMin

    fun yScr2Crt(y: Float, p: Plane) =
        p.yMax - y / p.yDen
}