package myImpatient

import scala.collection.mutable.ArrayBuffer

/**
  * Created by zhanghongwei on 12/11/16.
  */
class Chapter5 {

}

class Chapter51 extends Chapter5 {

}

abstract class Counter[+A] {
  private var value = 0

  def increment() {
    value += 1
  }

  // it is public, modified sth
  def current = value

  // return value, get value, no modifing
  def get: A // return value, get value, no modifing
}

class C2 extends Counter[Chapter5] {
  var value = 5

  // return value, get value, no modifing
  override def get = new Chapter51
}

object Chapter5 {
  def main(args: Array[String]): Unit = {

    val a = new Network2("hongwei")
    val chatter = new Network
    val fred = chatter.join("Fred")
    val hongwei = chatter.join("Hongwei")
    fred.contacts += hongwei
    fred.contacts += hongwei
    fred.contacts += hongwei
    fred.contacts += fred

    val myFace = new Network
    val wilma = myFace.join("wilma")
    fred.contacts += wilma

    val p4 = new Person1("hongwei", 29)
    p4.name
    val p1 = new Person
    val p2 = new Person("Fred")
    val p3 = new Person("Fred", 42)

    val counter = new C2
    counter.increment()
    counter.increment()
    counter.increment()
    val current = counter.current
    print(current)
    println()
    print(counter.get)

    val person: Person = new Person
    person.agePublic = 5
    println(person.agePublic)
    print(person.agePublic)
    val p5 = new PrivatePerson
    p5.age = 4
    print(p5.age)

    p5.privateAge2

    //TODO 5.7 main constructor
  }
}

class Person {
  println("hongwei")
  var agePublic = 0
  private var name = "Hongwei"
  private var age = 28

  def this(name: String) {
    this()
    this.name = name
  }

  def this(name: String, age: Int) {
    this(name)
    this.age = age
  }

}

class Person1(val name: String, age: Int, private val double: Double = 1.5) {
  println("Just constructed another person")

  def description = age + " years old" + double

  //  var agePublic = 0
  //  private var nameAuxiliary ="Hongwei"
  //  private var ageAuxiliary =28

  //  def this(name:String ,age:Int){
  //    this(name)
  //    this.ageAuxiliary= age
  //  }

}

class PrivatePerson {
  private var privateAge = 0
  // classs private
  private[this] var privateAge1 = 0
  // object private
  val privateAge2 = 0

  def age = privateAge

  def age_=(newValue: Int): Unit = {
    if (newValue > privateAge)
      privateAge = newValue
  }

  def isLess(other: PrivatePerson) = privateAge < other.privateAge
}

class Network {

  class Member(val name: String) {
    val contacts = new ArrayBuffer[Network#Member]
  }

  private val members = new ArrayBuffer[Member]

  def join(name: String): Member = {
    val m = new Member(name)
    members += m
    m
  }
}

//object Network{
//  class Member(val name: String){
//    val contacts = new ArrayBuffer[Member]
//  }
//}
class Network2(val name: String) {
//  outer =>

  class Member(val name: String) {
    def description = name + "inside" + this.name
  }

}

