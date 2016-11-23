package myImpatient

import java.io.File
import scala.io.Source

/**
  * Created by zhanghongwei on 15/11/16.
  */
//bk 21 Implicits 12=336-324
//Implicit conversions and implicit parameters are Scala’s power tools that do useful work behind the scenes

//bk 21.1 Implicit Conversions 324
object Chapter211 extends App {

  //eg1: convert integers n to fractions n / 1 implicit
  import scala.math._

  class Fraction(n: Int, d: Int) {
    private val num: Int = if (d == 0) 1 else n * sign(d) / gcd(n, d);
    private val den: Int = if (d == 0) 0 else d * sign(d) / gcd(n, d);

    override def toString = num + "/" + den

    def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0

    def gcd(a: Int, b: Int): Int = if (b == 0) abs(a) else gcd(b, a % b)

    def *(other: Fraction) = new Fraction(num * other.num, den * other.den)
  }

  object Fraction {
    def apply(n: Int, d: Int) = new Fraction(n, d)
  }

  implicit def int2Fraction(n: Int) = Fraction(n, 1) // convert integers n to fractions n / 1.

  val result = 3 * Fraction(4, 5) // Calls int2Fraction(3)--> Fraction(3, 1) * Fraction(4, 5)
  println(result)
  println(3)

}

//bk 21.2 Using Implicits for Enriching Existing Libraries
//1 create the new class and impliment what function you neeed
//2 implicit the older class into new class
object Chapter212 extends App {

  class RichFIle(val from: File) {
    def read = Source.fromFile(from.getPath).mkString
  }

  implicit def file2RichFile(from: File) = new RichFIle(from)

  val contents = new File("src/main/scala/myImpatient/Chapter21.scala").read
  println(contents)

}

//bk 21.3 Importing Implicits
//Scala will consider the following implicit conversion functions:
//1. Implicit functions in the companion object of the source or target type
//2. Implicit functions that are in scope as a single identifier
object Chapter213 extends App {

  import scala.math._

  class Fraction(n: Int, d: Int) {
    val num: Int = if (d == 0) 1 else n * sign(d) / gcd(n, d);
    val den: Int = if (d == 0) 0 else d * sign(d) / gcd(n, d);

    override def toString = num + "/" + den

    def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0

    def gcd(a: Int, b: Int): Int = if (b == 0) abs(a) else gcd(b, a % b)

    def *(other: Fraction) = new Fraction(num * other.num, den * other.den)
  }

  object Fraction {
    def apply(n: Int, d: Int) = new Fraction(n, d)
  }

  //    object FractionConversions {
  implicit def int2Fraction(n: Int) = Fraction(n, 1)

  implicit def fraction2Double(f: Fraction) = f.num * 1.0 / f.den

  //    }


  //    import myImpatient.FractionConversions

  // import com.horstmann.impatient.FractionConversions.fraction2Double
  // import com.horstmann.impatient.FractionConversions.{fraction2Double => _, _}

  val result = 3 * Fraction(4, 5) // Calls int2Fraction(3)
  println(result)

}

//bk 21.4 Rules for Implicit Conversions
//1 Implicit conversions are considered in three distinct situations:
//• If the type of an expression differs from the expected type:
//• If an object accesses a nonexistent member:
//• If an object invokes a method whose parameters don’t match the given arguments:

//On the other hand, there are three situations when an implicit conversion is not attempted:
//
// • No implicit conversion is used if the code compiles without it.
// For example, if a * b compiles, the compiler won’t try a * convert(b) or convert(a) * b.
//
//• The compiler will never attempt multiple conversions,
// such as convert1(convert2(a)) * b.
//
// • Ambiguous conversions are an error.
// For example, if both convert1(a) * b and convert2(a) * b are valid, the compiler will report an error.

object Chapter214 extends App {

}

//bk 21.5 Implicit Parameters
//The compiler looks for such an object in two places:
//
// • Among all val and def of the desired type that are in scope as a single identifier.
// • In the companion object of a type that is associated with the desired type.
// Associated types include the desired type itself, and, if it is a parameterized type, its type parameters.
object Chapter215 extends App {

  case class Delimiters(left: String, right: String)

  def quote(what: String)(implicit delims: Delimiters) =
    delims.left + what + delims.right

  quote("Bonjour le monde")(Delimiters("«", "»"))

  object FrenchPunctuation {
    implicit val quoteDelimiters = Delimiters("«", "»")
  }

  import FrenchPunctuation._

  //  import FrenchPunctuation.quoteDelimiters

  quote("Bonjour le monde")

}

//bk 21.6 Implicit Conversions with Implicit Parameters
object Chapter216 extends App {
  //  eg1
  //  def smaller[T](a:T, b:T) = if(a<b) a else b // error
  //  def smaller[T](a: T, b: T)(implicit order: T => Ordered[T]) = if (order(a) < b) a else b // supply a conversion function

  // order is not onlt a implicit paramer ,also a implicit convertion, so omit the call of order
  def smaller[T](a: T, b: T)(implicit order: T => Ordered[T]) = if (a < b) a else b

  smaller(40, 2)
  smaller("hong", "wei")

}

//bk 21.7 Context Bounds
object Chapter217 extends App {

  class MyPair[T: Ordering](val first: T, val second: T) {
    def smaller(implicit ord: Ordering[T]) =
      if (ord.compare(first, second) < 0) first else second
  }

  new MyPair(40, 2)

}

//bk 21.8 Evidence
object Chapter218 extends App {

//  def firstLast[A, C](it: C)(implicit ev: C <:< Iterable[A]) =
//    (it.head, it.last)
//
//  firstLast(List(1, 7, 2, 9))
//
//  firstLast("Fred")
//
//  implicitly[String <:< Iterable[_]]
//
//  implicitly[String <:< AnyRef]
//
//  implicitly[AnyRef <:< String]



}

//bk 21.9 The @implicitNotFound Annotat 336
object Chapter219 {

}
//bk 21.10 CanBuildFrom Demystified
object Chapter220 {


}