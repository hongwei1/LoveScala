package myImpatient

import java.awt.Color

import scala.List
import scala.collection.immutable.List
import scala.collection.mutable.ArrayBuffer
import scala.collection.{Map, SortedSet}

/**
  * Created by zhanghongwei on 14/11/16.
  */


//BK 13.1 The Main Collections Traits
object MainCollectionsTraits1 extends App {

  //eg1: normal iterator process
  val coll = Array(1, 7, 2, 9)
  // some Iterable
  val iter = coll.iterator
  while (iter.hasNext)
    println(iter.next())

  // uniform creation principle
  // eg2: each Scala collection contain a companion object with aplly method, to create the instance!
  private val ints: Iterable[Int] = Iterable(0xFF, 0xFF00, 0xFF0000)
  private val colors: Set[Color] = Set(Color.RED, Color.GREEN, Color.BLUE)
  private val colorToInt: Map[Color, Int] = Map(Color.RED -> 0xFF, Color.GREEN -> 0xFF00, Color.BLUE -> 0xFF0000)
  private val strings: SortedSet[String] = SortedSet("Hello", "World")
}


//BK 13.2 Mutable and Immutable Collections
object MutableAndImmutalbeCollections2 extends App {

  val immutableMap: Map[String, Int] = Map("Hello" -> 42) // Nobody can change it

  val mutableMap = new collection.mutable.HashMap[String, Int]

  val map: collection.Map[String, Int] = mutableMap

  //  immutableMap.put("Fred", 29) // Error
  mutableMap.put("Wilma", 17)
  //  map.put("Fred", 29) // Error

  import scala.collection.mutable

  val immutableMap1 = Map("Hello" -> 42)
  val mutableMap2 = new mutable.HashMap[String, Int]

  def digits(n: Int): Set[Int] =
    if (n < 0) {
      digits(-n)
    } else if (n < 10) {
      Set(n)
    } else
      digits(n / 10) + (n % 10)

  private val digits1: Set[Int] = digits(1729777)
  print(digits1)
}

//bk 13.3 Sequences
object Sequences3 extends App {
  //Vector Range
  val vec = (1 to 1000000) map (_ % 100) // map transforms a Range into a Vector

  val lst = vec.toList // Vector -->List

  def time[T](block: => T) = {
    val start = System.nanoTime
    val result = block
    val elapsed = System.nanoTime - start
    println(elapsed + " nanoseconds")
    result
  }

  time(vec(500000))

  time(lst(500000))

}

//BK 13.4 Lists
object List4 extends App {
  //eg1: create new List
  import scala.List

  val digits = scala.List(4, 2)
  9 :: digits
  9 :: 4 :: 2 :: Nil
  9 :: (4 :: (2 :: Nil))

  //eg2: Iterable List
  def sum(lst: List[Int]): Int =
  if (lst == Nil) 0 else lst.head + sum(lst.tail)

  sum(scala.List(9, 4, 2))

  //  def sum2(lst: List[Int]): Int = lst match {
  //    case Nil => 0
  //    case h :: t => h + sum(t) // h is lst.head, t is lst.tail // decountructor the List to Head and Tail.
  //  }

  sum(scala.List(9, 4, 2))

  //eg3: before you recucive , scala has been sum method
  scala.List(9, 4, 2).sum
}


//BK 13.5 Mutable Lists
object MutableLists5 extends App {

  val lst1 = scala.collection.mutable.LinkedList(1, -7, 2, -9)
  var cur1 = lst1
  while (cur1 != Nil) {
    if (cur1.elem < 0)
      cur1.elem = 0
    cur1 = cur1.next
  }

  var cur2 = lst1
  while (cur2 != Nil && cur2.next != Nil) {
    cur2.next = cur2.next.next
    cur2 = cur2.next
  }

  // Remove everything starting from the first negative number

  import scala.collection.mutable.LinkedList

  val lst = LinkedList(1, 7, -2, 9)

  var cur3 = lst
  while (cur3 != Nil && cur3.next != Nil) {
    if (cur3.next.elem < 0)
      cur3.next = LinkedList.empty // DO NOT set to null
    cur3 = cur3.next
  }
}

//BK 13.6 Sets
object Sets6 extends App {

  import scala.collection.mutable._

  Set(2, 0, 1) + 1
  private val strings1: LinkedHashSet[String] = LinkedHashSet("Mo", "Tu", "We", "Th", "Fr")
  collection.immutable.SortedSet(1, 2, 3, 4, 5, 6)

  private val b1: Boolean = strings1 contains "hongwei"
  private val b: Boolean = LinkedHashSet("Mo", "Tu") subsetOf strings1

  val primes = Set(2, 4, 5, 7)
  val digits = Set(1, 7, 2, 9)

  digits union primes //(1, 2, 3, 5, 7, 9)
  digits ++ primes

  digits & primes //(2, 7)
  digits intersect primes

  digits -- primes //(1, 9)
  digits diff primes
}


object Chapter13 extends App {


  //BK 13.7 Operators for Adding or Removing Elements
  val numbers = ArrayBuffer(1, 2, 3)
  var numbers1 = Set(1, 2, 3)
  numbers1 += 5

  Set(1, 2, 4) - 2

  //BK 13.9 Mapping a Function
  //  val names = List("Peter", "Paul", "Mary")
  //  private val map: List[String] = names.map(_ toUpperCase)
  //  private val strings2: List[String] = for (n <- names) yield n toUpperCase
  //
  //  def ulcase(s: String) = Vector(s.toUpperCase, s.toLowerCase)
  //
  //  names.map(ulcase)
  //  names.flatMap(ulcase)

  // partial function :may not be defined for all inputs. It yields only the values defined
  "-3+4*5/6".collect {
    case '+' => 1
    case '-' => 2
    case '*' => 3
    case '/' => 4
  }


  //BK 13.10 Reducing, Folding, and Scanning
  //  List(1, 7, 2, 9).reduceLeft(_ - _)
  //  List(1, 7, 2, 9).reduceRight(_ - _)
  //  List(1, 7, 2, 9).foldLeft("")(_ + _)
  //  List(1, 7, 2, 9).foldLeft(1)(_ - _)
  //  (0 /: List(1, 7, 2, 9)) (_ - _)
  //
  //  val freq = scala.collection.mutable.Map[Char, Int]()
  //  //  for
  //  //BK 13.11 Zipping
  //  val prices = List(5.0, 20.0, 9.95)
  //  val quantities = List(10, 2, 1)
  //  private val zip: List[(Double, Int)] = prices.zip(quantities)
  //  zip.map(p => p._1 * p._2)
  //  (zip.map(p => p._1 * p._2)).sum
  //
  //
  //  //bk 13.12 Iterators
  //
  //  //bk 13.13 Streams
  //  def numsFrom(n: BigInt): Stream[BigInt] = n #:: numsFrom(n + 1)
  //
  //  //#:: consturct a stream
  //  val tenOrMore = numsFrom(10)
  //  tenOrMore.tail.tail
  //
  //  //bk 13.14 Lazy Views
  //  val powers = (0 until 1000).view.map(scala.math.pow(10, _))
  //  powers(1000)
  //  (0 to 1000).map(scala.math.pow(10, _)).map(1 / _)
}






























