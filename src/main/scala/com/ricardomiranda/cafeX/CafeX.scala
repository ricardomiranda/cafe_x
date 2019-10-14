package com.ricardomiranda.cafeX

case class Item(name: String, price: Double)


case class Menu(items: List[Item] = List(
  Item(name = "Cola", price = 0.50),
  Item(name = "Coffe", price = 1.00),
  Item(name = "SteakSandwich", price = 4.5),
  Item(name = "SteakSandwich", price = 4.5))) {

  def price(item: String, menu: Menu): Double = {
    menu.items.filter(_ == item).head.price
  }
}

object Shopping {
  val menu = new Menu()

  def total(items: List[String], menu: Menu): Double = {
    items.map(i => menu.price(i, menu)).sum
  }
}