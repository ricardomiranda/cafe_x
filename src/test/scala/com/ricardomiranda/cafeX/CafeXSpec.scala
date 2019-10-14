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

    val expected: Double = 1
    val actual: Double = Shopping.total(items = items, menu = menu)
    assert(actual == expected)
  }
}
