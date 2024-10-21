```kotlin
import kotlin.math.abs

data class Point(val x: Double, val y: Double)

class Treug(val p1: Point, val p2: Point, val p3: Point) {
    private fun ploshad(p1: Point, p2: Point, p3: Point): Double {
        return abs((p1.x * (p2.y - p3.y) + p2.x * (p3.y - p1.y) + p3.x * (p1.y - p2.y)) / 2.0)
    }

    fun contains(point: Point): Boolean {
        val totalPloshad = ploshad(p1, p2, p3)
        val ploshad1 = ploshad(point, p2, p3)
        val ploshad2 = ploshad(p1, point, p3)
        val ploshad3 = ploshad(p1, p2, point)
        return totalPloshad == ploshad1 + ploshad2 + ploshad3
    }
}

fun safeInput(prompt: String): Double {
    while (true) {
        try {
            print(prompt)
            return readLine()?.toDouble() ?: throw NumberFormatException()
        } catch (e: NumberFormatException) {
            println("Ошибка: Введите корректное число.")
        }
    }
}

fun main() {
    val x1 = safeInput("x1: ")
    val y1 = safeInput("y1: ")
    val x2 = safeInput("x2: ")
    val y2 = safeInput("y2: ")
    val x3 = safeInput("x3: ")
    val y3 = safeInput("y3: ")

    val x = safeInput("x: ")
    val y = safeInput("y: ")

    val treug = Treug(Point(x1, y1), Point(x2, y2), Point(x3, y3))
    val point = Point(x, y)

    if (treug.contains(point)) {
        println("Точка находится внутри треугольника.")
    } else {
        println("Точка находится вне треугольника.")
    }
}
```