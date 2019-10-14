package com.ricardomiranda.cafeX

import scala.math.max

sealed trait FoodType
case object Drink extends FoodType
case object ColdFood extends FoodType
case object HotFood extends FoodType

case class Item(price: Double, foodType: FoodType)

case class Menu(items: Map[String, Item] = Map(
  "Cola" -> Item(price = 0.50, foodType = Drink),
  "Coffee" -> Item(price = 1.00, foodType = Drink),
  "Cheese Sandwich" -> Item(price = 2.0, foodType = ColdFood),
  "Steak Sandwich" -> Item( price =  4.5, foodType = HotFood))) {

  def price(item: String): Double = this.items(item).price

  def ItemsByType(foodType: FoodType): List[String] = this.items.filter(_._2.foodType == foodType).map(_._1).toList
}

object Shopping {
  def total(items: List[String], menu: Menu): Double = items.map(menu.price(_)).sum
}

object ServiceCharge {
  def containsTypeOfFood(items: List[String], menu: Menu, foodType: FoodType): Boolean = items.toSet.intersect(menu.ItemsByType(foodType = foodType).toSet) match {
    case  xs if xs.size == 0 => false
    case _ => true
  }

  def containsDrinks(items: List[String], menu: Menu): Boolean = this.containsTypeOfFood(items = items, menu = menu, foodType = Drink)
  def containsColdFood(items: List[String], menu: Menu): Boolean = this.containsTypeOfFood(items = items, menu = menu, foodType = ColdFood)
  def containsHotfood(items: List[String], menu: Menu): Boolean = this.containsTypeOfFood(items = items, menu = menu, foodType = HotFood)

  def serviceValue(items: List[String], menu: Menu, bill: Double): Double = items match {
    case items if this.containsHotfood(items = items, menu = menu) => max(20.00, 0.20 * bill)
    case items if this.containsColdFood(items = items, menu = menu) => 0.10 * bill
    case _ => 0.00
  }
}