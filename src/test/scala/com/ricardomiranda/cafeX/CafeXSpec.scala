package com.ricardomiranda.cafeX

import org.scalatest.FunSuite

class CafeXSpec extends FunSuite {
  val menu: Menu = new Menu()

  test("Price of coffee") {
    val item: String = "Coffee"

    val expected: Double = 1.00
    val actual: Double = menu.price(item)
    assert(actual == expected)
  }

  test("Total Price of empty shopping list") {
    val items: List[String] = List()

    val expected: Double = 0
    val actual: Double = Shopping.total(items = items, menu = menu)
    assert(actual == expected)
  }

  test("Total Price of shopping list with 1 coffee") {
    val items: List[String] = List("Coffee")

    val expected: Double = 1.00
    val actual: Double = Shopping.total(items = items, menu = menu)
    assert(actual == expected)
  }

  test("Total Price of shopping list with 2 coffees") {
    val items: List[String] = List("Coffee", "Coffee")

    val expected: Double = 2.00
    val actual: Double = Shopping.total(items = items, menu = menu)
    assert(actual == expected)
  }

  test("Total Price of shopping list with 2 coffees and 1 Steak Sandwich") {
    val items: List[String] = List("Coffee", "Coffee", "Steak Sandwich")

    val expected: Double = 6.50
    val actual: Double = Shopping.total(items = items, menu = menu)
    assert(actual == expected)
  }

  test("Total Price of shopping list with 1 Cola, 1 coffee and 1 Cheese Sandwich") {
    val items: List[String] = List("Cola", "Coffee", "Cheese Sandwich")

    val expected: Double = 3.50
    val actual: Double = Shopping.total(items = items, menu = menu)
    assert(actual == expected)
  }
}
