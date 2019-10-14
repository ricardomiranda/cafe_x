package com.ricardomiranda.cafeX


case class Menu(items: Map[String, Double] = Map(
  "Cola" -> 0.50,
  "Coffee" -> 1.00,
  "Cheese Sandwich" -> 2.0,
  "Steak Sandwich" -> 4.5)) {

  def price(item: String): Double = this.items(item)
}

object Shopping {
  def total(items: List[String], menu: Menu): Double = {
    items.map(menu.price(_)).sum
  }
}