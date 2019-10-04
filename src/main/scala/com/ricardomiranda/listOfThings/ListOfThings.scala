package com.ricardomiranda.listOfThings

case class Item(name: String, price: Double)


case class menu(items: List[Item])

object menu {
  def apply(): Unit = {
    val cola = Item(name = "Cola", price = 0.50)
    val coffe = Item(name = "Coffe", price = 1.00)
    val cheeseSandwich = Item(name = "Cheese Sandwich", price = 2.00)
    val steakSandwich = Item(name = "SteakSandwich", price = 4.5)

    val menu = List(cola, coffe, cheeseSandwich, steakSandwich)

    new menu(items = menu)
  }
}

object shopping {
  def total(items: List[String]): Double = {
    2
  }
}