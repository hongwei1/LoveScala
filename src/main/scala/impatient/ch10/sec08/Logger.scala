package impatient.ch10.sec08

trait Logged {
  def log(msg: String) { }
}

trait ConsoleLogger extends Logged {
  override def log(msg: String) { println(msg) }
}

trait ShortLogger extends Logged {
  val maxLength = 15 
  override def log(msg: String) {
    super.log(
      if (msg.length <= maxLength) msg else msg.substring(0, maxLength - 3) + "...")
  }
}

class Account {
  protected var balance = 0.0
}

class SavingsAccount extends Account with ConsoleLogger with ShortLogger {
  var interest = 0.0
  def withdraw(amount: Double) {
    if (amount > balance) log("Insufficient funds")
    else balance -= amount
  }

  // More methods ...
}

object Main extends App {
  val acct = new SavingsAccount
  acct.withdraw(100)
}

/*

$ javap -private Account.class 
Compiled from "Logger.scala"
public class Account implements scala.ScalaObject {
  private double balance;
  ...
}

$ javap -private SavingsAccount.class 
Compiled from "Logger.scala"
public class SavingsAccount extends Account implements ShortLogger,scala.ScalaObject {
  private double interest;
  private final int maxLength;
  ...
}

*/
