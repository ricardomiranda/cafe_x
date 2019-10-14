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


  test("List of drinks") {
    val expected: List[String] = List("Cola", "Coffee")
    val actual: List[String] = menu.ItemsByType(foodType = Drink)
    assert(actual == expected)
  }

  test("List of hot food") {
    val expected: List[String] = List("Cheese Sandwich")
    val actual: List[String] = menu.ItemsByType(foodType = ColdFood)
    assert(actual == expected)
  }

  test("List of cold food") {
    val expected: List[String] = List("Steak Sandwich")
    val actual: List[String] = menu.ItemsByType(foodType = HotFood)
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

  test("Empty list does not contains drinks") {
    val items: List[String] = List()

    val actual: Boolean = ServiceCharge.containsDrinks(items = items, menu = menu)
    assert(!actual)
  }

  test("List with Cola contains drinks") {
    val items: List[String] = List("Cola")

    val actual: Boolean = ServiceCharge.containsDrinks(items = items, menu = menu)
    assert(actual)
  }

  test("Service charge for empty list is 0.00") {
    val items: List[String] = List()
    val bill: Double = Shopping.total(items = items, menu = menu)

    val expected: Double = 0.00
    val actual: Double = ServiceCharge.serviceValue(items = items, menu = menu, bill = bill)
    assert(actual == expected)
  }

  test("Service charge for list of drinks is 0.00") {
    val items: List[String] = List("Cola", "Cola", "Coffee")
    val bill: Double = Shopping.total(items = items, menu = menu)

    val expected: Double = 0.00
    val actual: Double = ServiceCharge.serviceValue(items = items, menu = menu, bill = bill)
    assert(actual == expected)
  }

  test("Service charge for list of with hot food is 20.00 max") {
    val items: List[String] = List("Cola", "Cola", "Coffee", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich")
    val bill: Double = Shopping.total(items = items, menu = menu)

    val expected: Double = 20.00
    val actual: Double = ServiceCharge.serviceValue(items = items, menu = menu, bill = bill)
    assert(actual == expected)
  }
}
