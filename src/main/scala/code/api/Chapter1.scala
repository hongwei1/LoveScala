package code.api

import java.math.BigInteger


/**
  * Created by zhanghongwei on 09/11/16.
  */
class Chapter1 {
//  def main(args: Array[String]): Unit = {
//    BigInt.probablePrime(100,scala.util.Random)
//  }
  def myClass: Unit ={
    print("haha")
  }

}
object Chapter1{
  val int: BigInt = new BigInt(new BigInteger("123"))

  def main(args: Array[String]): Unit = {
    print(BigInt.probablePrime(100,scala.util.Random))
//    "Hello".distinct
    "Hello"(4)
    val hello: String = "Hello"
    hello.apply(4)
    "Hello".apply(1)
    "helo".apply(1)
    "Hello".split("a")

    BigInt("123")

    BigInt.apply("123")
    Array(1,4,9,16)
    "HongWei".count(_.isUpper)
    3
    val patch: String = "Harry".patch(1,"ung",2)
    4
    5
  }
  def mynumber={
    print(BigInt.probablePrime(100,scala.util.Random))
  }

}
