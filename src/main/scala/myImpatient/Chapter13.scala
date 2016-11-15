package myImpatient

import java.awt.Color

import scala.collection.mutable.ArrayBuffer
import scala.collection.{Map, SortedSet}
import scala.math._
/**
  * Created by zhanghongwei on 14/11/16.
  */
class Chapter13 {

}

object Chapter13 extends App {
  //BK 13.1 The Main Collections Traits
  // uniform creation principle
  private val ints: Iterable[Int] = Iterable(0xFF, 0xFF00, 0xFF0000)
  private val colors: Set[Color] = Set(Color.RED, Color.GREEN, Color.BLUE)
  private val colorToInt: Map[Color, Int] = Map(Color.RED -> 0xFF, Color.GREEN -> 0xFF00, Color.BLUE -> 0xFF0000)
  private val strings: SortedSet[String] = SortedSet("Hello", "World")

  // BK 13.2 Mutable and Immutable Collections
  private val stringToInt: Map[String, Int] = scala.collection.Map("Hello" -> 42)
  private val stringToInt1: Map[String, Int] = Map("Hello" -> 42)

  import scala.collection.mutable

  private val stringToInt2: Map[String, Int] = Map("hongwei" -> 28)
  private val stringToInt3: mutable.Map[String, Int] = mutable.Map("yanlu" -> 15)

  private val colors1: Set[Color] = colors + Color.RED

  def digits(n: Int): Set[Int] =
    if (n < 0) digits(-n)
    else if (n < 10) Set(n)
    else digits(n /10) + (n % 10)


  private val digits1: Set[Int] = digits(5)
  val a = 5

  //bk 13.3 Sequences
  //Vector Range


  //BK 13.4 Lists
  val digits134 = List(4, 2)
  // head elments and tail List
  private val ints1: List[Int] = 9 :: List(4, 2)
  private val ints2: List[Int] = List(9, 4, 2)
  9 :: 4 :: 2 :: Nil

  def sum(lst: List[Int]): Int =
    if (lst == Nil) 0
    else lst.head + sum(lst.tail)

  def sum1(lst: List[Int]): Int = lst match {
    case Nil => 0
    case h :: t => h + sum(t) // h is lst.head ,t is lst.tail.“destructures” the list into head and tail.
  }

  List(9, 4, 2).sum

  //BK 13.5 Mutable Lists
  private val lst: mutable.LinkedList[Int] = scala.collection.mutable.LinkedList(1, -2, 5, -9)
  var cur = lst
  while (cur != Nil) {
    if (cur.elem < 0) cur.elem = 0
    cur = cur.next
  }

  while (cur != Nil && cur.next != Nil) {
    cur.next = cur.next.next
    cur = cur.next
  }

  mutable.LinkedList.empty

  //BK 13.6 Sets
  Set(2, 0, 1) + 1
  private val strings1: mutable.LinkedHashSet[String] = mutable.LinkedHashSet("Mo", "Tu", "We", "Th", "Fr")


  private val b1: Boolean = strings1 contains "hongwei"
  private val b: Boolean = mutable.LinkedHashSet("Mo", "Tu") subsetOf strings1

  val primes = Set(2, 4, 5, 7)
  val digits136 = Set(1, 7, 2, 9)

  digits136 union primes
  digits136 ++ primes

  digits136 & primes
  digits136 intersect primes

  digits136 -- primes
  digits136 diff primes

  //BK 13.7 Operators for Adding or Removing Elements
  val numbers = ArrayBuffer(1, 2, 3)
  var numbers1 = Set(1, 2, 3)
  numbers1 += 5

  Set(1, 2, 4) - 2

  //BK 13.9 Mapping a Function
  val names = List("Peter", "Paul", "Mary")
  private val map: List[String] = names.map(_ toUpperCase)
  private val strings2: List[String] = for (n <- names) yield n toUpperCase

  def ulcase(s: String) = Vector(s.toUpperCase, s.toLowerCase)

  names.map(ulcase)
  names.flatMap(ulcase)

  // partial function :may not be defined for all inputs. It yields only the values defined
  "-3+4*5/6".collect {
    case '+' => 1
    case '-' => 2
    case '*' => 3
    case '/' => 4
  }


  //BK 13.10 Reducing, Folding, and Scanning
  List(1, 7, 2, 9).reduceLeft(_ - _)
  List(1, 7, 2, 9).reduceRight(_ - _)
  List(1, 7, 2, 9).foldLeft("")(_ + _)
  List(1, 7, 2, 9).foldLeft(1)(_ - _)
  (0 /: List(1, 7, 2, 9)) (_ - _)

  val freq = scala.collection.mutable.Map[Char, Int]()
  //  for
  //BK 13.11 Zipping
  val prices = List(5.0, 20.0, 9.95)
  val quantities = List(10, 2, 1)
  private val zip: List[(Double, Int)] = prices.zip(quantities)
  zip.map(p => p._1 * p._2)
  (zip.map(p => p._1 * p._2)).sum


  //bk 13.12 Iterators

  //bk 13.13 Streams
  def numsFrom(n: BigInt): Stream[BigInt] = n #:: numsFrom(n + 1)

  //#:: consturct a stream
  val tenOrMore = numsFrom(10)
  tenOrMore.tail.tail

  //bk 13.14 Lazy Views
  val powers = ( 0 until 1000).view.map(scala.math.pow(10,_))
  powers(1000)
  (0 to 1000).map(scala.math.pow(10,_)).map(1 / _)
}






























