package com.ricardomiranda.cafeX

object Main extends App {
  val menu: Menu = new Menu()

  val items: List[String] = List("Coffee")
  val bill: Double = Shopping.total(items= items, menu = menu)
  val serviceCharge: Double = ServiceCharge.serviceValue(items = items, menu = menu, bill = bill)
  val totalCost: Double = bill + serviceCharge

  println("With items:")
  items.foreach(println(_))
  println(s"Price of items is ${bill}")
  println(s"Service charge is ${serviceCharge}")
  println(s"Total cost is ${totalCost}")
}
