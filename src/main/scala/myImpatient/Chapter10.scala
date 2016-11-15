package myImpatient.chapter10

import java.io.{IOException, PrintStream, PrintWriter}

/**
  * Created by zhanghongwei on 13/11/16.
  */
class Chapter10 {

}

object Chapter10 extends App {

  new UnhappyException
  //  val f = new JFrame with LoggedException13
  val acct = new SavingsAccount with ConsoleLogger
  acct.withdraw(100.0)
  val acct0 = new SavingsAccount with FileLogger

  trait FileLogger

  val acct1 = new SavingsAccount with ConsoleLogger with TimestampLogger with ShortLogger
  acct1.withdraw(10)
  val acct2 = new SavingsAccount with ConsoleLogger with ShortLogger with TimestampLogger
  acct2.withdraw(122)

  val acct3 = new SavingsAccount with FileLogger {
    val filename = "map.log"
  }

}

//bk 10.2 Traits as Interfaces
trait Logger {
  def log(msg: String)

  // abstract method
  def info(msg: String) {
    log("INFO +" + msg)
  }

  // abstract method
  def warn(msg: String) {
    log("warn +" + msg)
  }

  // abstract method
  def severe(msg: String) {
    log("severe +" + msg)
  } // abstract method
}

//bk 10.3 Traits with Concrete Implementations
trait ConsoleLogger extends Logger with Cloneable with Serializable with Logged {
  override def log(msg: String) {
    println(msg)
  }
}

class Account {
  protected var balance = 0.0
}

trait Logged {
  def log(msg: String) {}
}

class SavingsAccount extends Account with Logged {
  def withdraw(amount: Double): Unit = {
    if (amount > balance) log("Insufficient funds")
    else balance -= amount

  }
}

//bk 10.4 Objects with Traits
//bk 10.5 Layered Traits

trait TimestampLogger extends Logged {
  override def log(msg: String) {
    super.log(new java.util.Date() + " " + msg)
  }
}

trait ShortLogger extends Logged {

  val maxLength = 15

  override def log(msg: String): Unit = {
    if (msg.length <= maxLength) msg
    else msg.substring(0, maxLength - 3) + "..."
  }
}

//Bk 10.7 Traits for Rich Interfaces
//BK 10.8 Concrete Fields in Traits
//BK 10.10 Trait Construction Order
//trait  FileLogger extends Logger{
//  val out = new PrintWriter("App.log")
//  out.println("#" + new Date().toString)
//  def log(msg: String): Unit = {
//    out.print(msg)
//    out.flush()
//  }
//}

trait FileLogger extends Logger {
  val filename: String
  val out = new PrintStream(filename)

  def log(msg: String): Unit = {
    out.print(msg)
    out.flush()
  }
}

//bk 10.12 Traits Extending Classes
trait LoggerException extends Exception with Logged {
  def log(): Unit = {
    log(getMessage)
  }
}

class UnhappyException extends IOException with LoggerException {
  override def getMessage: String = "arggh!"
}

//BK 10.13 Self Types

trait LoggedException13 extends Logged {
  this: Exception =>
  def log() {
    log(getMessage)
  }
}

trait LoggedException131 extends Logged {
  this: {def getMessage(): String} =>
  def log() {
    log(getMessage())
  }
}