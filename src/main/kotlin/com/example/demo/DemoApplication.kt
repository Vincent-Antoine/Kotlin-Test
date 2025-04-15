package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.security.Key

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)

	/*val x: String = "Bonjour "
	var y: String = "Hello"
	y += " World"

	val resultat = sum("$x", "$y")
	println("$resultat")*/



		/*val shapes: List<Shape> = listOf(
			Circle(2.0),
			Rectangle(4.0, 5.0)
		)

		for (shape in shapes) {
			println("Surface = ${shape.area()}")
		}*/

	val cesar = cesar('A',4)
	println("$cesar")

}

fun cesar(a: Char, b: Int): Char {
	if (b <= 0) error("Le décalage doit être supérieur à 0")
	if (a !in 'A'..'Z') error("Le caractère doit être entre A et Z")

	val base = 'A'.code
	println("La valeur de base est : $base")

	/*Donc si on à pour valeur de base a=A et b=1 alors on aura A - la valeur de base donc A + 1
	ce qui revient a A - A = rien, mais +1 = A donc resultat final A*/
	val offset = (a.code - base + b) % 26
	println("La valeur de offset (donc le decallage) est : $offset")
	println("On aura donc le base + la valeur de decallage soit : $base + $offset")

	return (base + offset).toChar()
}




/*fun sum(a: String, b: String): String {
	return a + b
}*/

/*interface Shape {
	fun area(): Double
}
class Circle(private val radius: Double) : Shape {
	override fun area() = Math.PI * radius * radius
}
data class Rectangle(val length: Double, val height: Double) : Shape {
	override fun area() = length * height
}
*/


