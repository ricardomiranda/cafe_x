package com.ricardomiranda.cafeX

import scala.annotation.tailrec

object Main extends App {
  val menu: Menu = new Menu()

  val items: List[String] = itemsToPurchase(List())
  val bill: Double = Shopping.total(items= items, menu = menu)
  val serviceCharge: Double = ServiceCharge.serviceValue(items = items, menu = menu, bill = bill)
  this.bill(items = items, bill = bill, serviceCharge = serviceCharge)

  @tailrec
  def itemsToPurchase(items: List[String]): List[String] = {
    readLine(
      """Insert name of item (press Enter to finish your purchase)?
        |""".stripMargin).trim match {
      case "" => items
      case i => itemsToPurchase(items = i :: items)
    }
  }

  def bill(items: List[String], bill: Double, serviceCharge: Double): Unit = {
    val totalCost: Double = bill + serviceCharge

    println("With items:")
    items.foreach(println(_))
    println(s"Price of items is ${bill}")
    println(s"Service charge is ${serviceCharge}")
    println(s"Total cost is ${totalCost}")
  }
}
