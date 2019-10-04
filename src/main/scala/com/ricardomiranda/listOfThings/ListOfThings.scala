package com.ricardomiranda.listOfThings

case class Item(name: String, price: Double)


case class Menu(items: List[Item])

object Menu {
  def apply(): Unit = {
    val cola = Item(name = "Cola", price = 0.50)
    val coffe = Item(name = "Coffe", price = 1.00)
    val cheeseSandwich = Item(name = "Cheese Sandwich", price = 2.00)
    val steakSandwich = Item(name = "SteakSandwich", price = 4.5)
    val menu = List(cola, coffe, cheeseSandwich, steakSandwich)

    new Menu(items = menu)
  }

  def price(item: String, menu: Menu): Double = {
    menu.items.filter(_ == item).head.price
  }
}

object shopping {
  def total(items: List[String], menu: Menu): Double = {
    items.map(i => Menu.price(i, menu)).sum
  }
}