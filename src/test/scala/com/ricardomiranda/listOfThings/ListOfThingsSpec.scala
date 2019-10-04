package com.ricardomiranda.listOfThings

import org.scalatest.FunSuite

class ListOfThingsSpec extends FunSuite {
  val menu = new Menu()

  test("Prie of 1 coffe") {
    val items = List("Coffe")
    assert(Shopping.total(items = items, menu = menu) == 0)
  }
}
