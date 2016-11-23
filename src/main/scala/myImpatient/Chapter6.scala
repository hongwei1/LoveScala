package myImpatient

//package  com{
//  package horstman{
//    package impatient{
//      class Employee{
//
//      }
//      object Employee{
//        val name = "hongwei6"
//      }
//    }
//  }
//}

import TrafficLightColor.TrafficLightColor

/**
  * Created by zhanghongwei on 12/11/16.
  */
class Chapter6 {
  println("Hong wei ,come on!!!")


}

object Chapter6 extends App {

  def doWhat(color :TrafficLightColor) ={
    if (color == TrafficLightColor.Red)"Stop"
    else if (color == TrafficLightColor.Yellow) "Hurry up"
    else "go"
  }

  for(c <- TrafficLightColor.values) println(c.id + ": "+c)
  TrafficLightColor(0)
  TrafficLightColor.withName("Red")
  doWhat(TrafficLightColor.Red)

  //BK 6.4 apply
  val array: Array[Int] = new Array[Int](10)
  // normal
  val ints: Array[Int] = Array(5)
  Array("Mary", "had", "a", "little", "lamb")
  //apply
  val ints1: Array[Array[Int]] = Array(Array(1, 7), Array(2, 9))
  val array1: Array[Nothing] = new Array(100)
  val ints2: Array[Int] = Array(100)
  private val accounts: Accounts = Accounts(50)
  Accounts(100.0)

  val action = Map("Open" -> DoNothingAction, "Save" -> DoNothingAction)
  println("hongwei")
  val chapter61: Chapter6 = new Chapter6
  val chapter62: Chapter6 = new Chapter6

  Accounts.newUniqueNumber()
  Accounts.name
  Accounts.newUniqueNumber()

}

//TODO train with or extends???

object Accounts {
  //BK 6.1 Singleton
  //  • As a home for utility functions or constants
  //  • When a single immutable instance can be shared efficiently
  //  • When a single instance is required to coordinate some service (the singleton design pattern)
  //BK 6.2 Companion Object
  //   Companion and class can call the private properties , only when they are in the same file
  println("constructor only call at the first time !")
  val name = "hongwei"
  private var lastNumber = 0

  def newUniqueNumber() = {
    lastNumber += 1;
    lastNumber
  }

  def apply(initialBalance: Double) =
    new Accounts("hongwei", initialBalance)
}

class Accounts(val name: String = "hanger", initialBalance: Double) {
  private var balance = initialBalance
  println("constructor only call at the first time !")
  val id = Accounts.newUniqueNumber()
  //  private var balance = 0.0

  //  def deposit(amount: Double): Unit = {
  //    balance += amount
  //  }

}

//BK 6.3 Objects Extending a Class or Trait
abstract class UndoableAction(val description: String) {
  def undo(): Unit

  def redo(): Unit
}

object DoNothingAction extends UndoableAction("Do nothing") {
  override def undo(): Unit = {}

  override def redo(): Unit = {}
}

//BK 6.6 Trait Enumerations
object TrafficLightColor extends Enumeration {
  type TrafficLightColor = Value
  val Red, Yellow, Green = Value
}



