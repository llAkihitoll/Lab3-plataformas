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

// Función principal
fun main() {
    val burger = Burger("Clásica", 50.0)
    val pizza = Pizza("Pepperoni", 80.0)
    val iceCream = IceCream("Vainilla", 30.0)
    val juice = Juice("Naranja", 25.0)

    val items = listOf(burger, pizza, iceCream, juice)

    for (item in items) {
        println(item.cook())
    }

    println(iceCream.eat())

    println("Precio con 10% de descuento de la hamburguesa: Q${"%.2f".format(burger.discountedPrice(10.0))}")
}
