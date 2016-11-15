package myImpatient

import java.awt.event.{ActionEvent, ActionListener}
import javax.swing.JButton

import scala.collection.immutable.IndexedSeq
import scala.math.{ceil, sqrt}

/**
  * Created by zhanghongwei on 14/11/16.
  */
class Chapter12 {

}


object Chapter12 extends App {
  //BK 12.1 Functions as Values
  //1 call it
  //2 pass it. by storing it in a variable or giving it to a function as a parameter :varible or parameter.


  val num = 3.14
  val fun = ceil _ //change method to functions. difference ???
  // 方法不App是值，而函数是
  fun(num)

  // just as the normal method grammers. only differnec is it is just a function variable ,not a fixed function

  def increment(n: Int) = n + 1

  // method??
  val fun1 = increment _ // change the methods to functions

  List(1, 2, 3).map(increment _) //change mothods to functions automaticly
  List(1, 2, 3).map(increment)

  def m1(x: Int) = x + 3

  def abs(x: Double) = if (x >= 0) x else -x

  val f1 = (x: Int) => x + 3
  val f2 = abs _
  Array(3.14, 1.42, 2.0).map(fun)

  //BK 12.2 Anonymous Functions
  val doubleToDouble: (Double) => Double = (x: Double) => 3 * x
  val Double = doubleToDouble

  val triple = (x: Double) => 3 * x

  def triple1(x: Double) = 3 * x

  Array(3.14, 1.42, 2.0).map((x: Double) => 3 * x)
  Array(3.14, 1.42, 2.0).map(triple)
  Array(3.14, 1.42, 2.0).map(triple1 _)
  Array(3.14, 1.42, 2.0).map {
    triple1 _
  }

  val abc = 5;

  //BK 12.3 Functions with Function Parameters
  def valueAtOneQuarter(f: (Double) => Double) = f(0.25)

  // receive a function
  def mulBy(factor: Double) = (x: Double) => factor * x // can produce a funciton


  // input is a function : input(Double)-> output(Double),and return the value of 0.25
  def triple2(x: Double) = 3 * x //input is double x, and return 3*x is a value
  valueAtOneQuarter(ceil _)
  // It is a getting the function paramers functions , it is called high order funciton
  // High order function can create another function.
  private val quarter: Double = valueAtOneQuarter(sqrt _)

  private val by = mulBy(4) // (x:Double) => 3*x
  by(3)



  //BK 12.4 Parameter Inference
  valueAtOneQuarter((x: Double) => 3 * x)
  valueAtOneQuarter((x) => 3 * x) // not return type
  valueAtOneQuarter(x => 3 * x) // not parates
  valueAtOneQuarter(3 * _)
  // only once right you can use _ , it is ultimate  only happen when the paramters are known
  val fun124: (Double) => Double = 3 * (_: Double)
  //OK
  val fun1241: (Double) => Double = d => 3 * d

  //(paramters) => result types
  val a = 5

  //BK 12.5 Useful Higher-Order Functions
  //1 map
  private val doubles: IndexedSeq[Double] = (1 to 9) map (0.1 * _)
  doubles
  //principle : if you want a sequence of values ,see if you can transform if from a simpler one !!!
  //2 foreach
  private val Unit1: Unit = (1 to 9) map ("*" * _) foreach (println _)
  Unit1
  //foreach simply apply the fucntion to each argument // map return a value
  // filter : yields all elements that match a particular condition
  //3 filter
  private val ints: IndexedSeq[Int] = (1 to 9) filter (_ % 2 == 0)
  //4 reduceLeft
  private val i: Int = (1 to 9) reduceLeft (_ * _) //1*2*3*4....*9
  //5 sortWith
  "Mary has a little lamb".split(" ").sortWith(_.length < _.length)

  //BK 12.6 Closures
  //  def mulBy(factor: Double) = (x: Double) => factor * x
  val triple126 = mulBy(3)
  // each of the returned functions has its own setting for factor : clousure consists of code together with variables
  val half = mulBy(0.5) // implemented as objects of a class ,with an instance variable factor and apply method
  println(triple126(14) + " " + half(14))
  // can access nonlocal variables.


  //BK 12.7 SAM Conversions
  // interfaces have a single abstract method-SAM in java
  var counter = 0
  val button = new JButton("Increment")

  button.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      counter += 1
    }
  })

  // change a function to an actionListenner instance!
  implicit def makeAction(action: (ActionEvent) => Unit) =
  new ActionListener {
    override def actionPerformed(event: ActionEvent) {
      action(event)
    }
  }

  button.addActionListener((event: ActionEvent) => counter += 1)

  //bk 12.8 Currying
  // process -> turning a function two arguments into a function takes one argument
  def mul(x: Int, y: Int) = x * y

  def mulOneAtTime(x: Int) = (y: Int) => x * y

  //--> shortcut
  def mulOneAtTimeShort(x: Int)(y: Int) = x * y

  mulOneAtTime(6)(7)
  mul(6, 7)


  val ttttttttttt = 6
}

object Tool {
  def increment(n: Int) = n + 1

  def increment(n: Int, step: Int): Int = n + step
}



















