// Clase abstracta base
abstract class Food(val name: String, val price: Double) {
    abstract fun cook(): String
}

// Subclase de Food para hamburguesas
class Burger(name: String, price: Double) : Food(name, price) {
    override fun cook(): String = "Asando la hamburguesa $name"
}

// Subclase de Food para pizzas
class Pizza(name: String, price: Double) : Food(name, price) {
    override fun cook(): String = "Horneando la pizza $name"
}

// Interfaz Dessert
interface Dessert {
    fun eat(): String
}

// Subclase de Food que implementa Dessert
class IceCream(name: String, price: Double) : Food(name, price), Dessert {
    override fun cook(): String = "Enfriando el helado $name"
    override fun eat(): String = "Comiendo el helado $name"
}

// Clase abstracta Drink que hereda de Food
abstract class Drink(name: String, price: Double) : Food(name, price) {
    abstract fun pour(): String
}

// Subclase Juice de Drink
class Juice(name: String, price: Double) : Drink(name, price) {
    override fun cook(): String = "Exprimiendo el jugo $name"
    override fun pour(): String = "Sirviendo el jugo $name"
}

// Extension function para precio con descuento
fun Food.discountedPrice(discountPercent: Double): Double {
    return price * (1 - discountPercent / 100)
}

import java.util.Scanner

abstract class Food(val name: String, val price: Double) {
    abstract fun cook(): String
}

class Burger(name: String, price: Double) : Food(name, price) {
    override fun cook(): String = "Asando la hamburguesa $name"
}

class Pizza(name: String, price: Double) : Food(name, price) {
    override fun cook(): String = "Horneando la pizza $name"
}

interface Dessert {
    fun eat(): String
}

class IceCream(name: String, price: Double) : Food(name, price), Dessert {
    override fun cook(): String = "Enfriando el helado $name"
    override fun eat(): String = "Comiendo el helado $name"
}

abstract class Drink(name: String, price: Double) : Food(name, price) {
    abstract fun pour(): String
}

class Juice(name: String, price: Double) : Drink(name, price) {
    override fun cook(): String = "Exprimiendo el jugo $name"
    override fun pour(): String = "Sirviendo el jugo $name"
}

fun Food.discountedPrice(discountPercent: Double): Double {
    return price * (1 - discountPercent / 100)
}

fun main() {
    val scanner = Scanner(System.`in`)

    val foods = mapOf(
        1 to Burger("Clásica", 50.0),
        2 to Pizza("Pepperoni", 80.0),
        3 to IceCream("Vainilla", 30.0),
        4 to Juice("Naranja", 25.0)
    )

    println("Seleccione un alimento:")
    println("1. Hamburguesa")
    println("2. Pizza")
    println("3. Helado")
    println("4. Jugo")

    val choice = scanner.nextInt()
    val item = foods[choice]

    if (item != null) {
        println(item.cook())

        if (item is IceCream) {
            println(item.eat())
        }

        if (item is Burger) {
            println("Precio con 10% de descuento: Q${"%.2f".format(item.discountedPrice(10.0))}")
        }
    } else {
        println("Opción no válida.")
    }
}

