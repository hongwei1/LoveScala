import org.scalatest.FlatSpec
import org.scalatest.Tag

object DbTest extends Tag("com.mycompany.tags.DbTest")

import scala.collection.mutable.Stack
import org.scalatest.Assertions._

class StackSpec extends FlatSpec {
  "A Stack" should "pop values in last-in-first-out order !" in {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    assert(stack.pop == 2)
    assert(stack.pop == 1)


  }
  it should "throw NoSuchElementException if an empty stack is popped !" in {
    val emptyStack = new Stack[String]
    assertThrows[NoSuchElementException] {
      emptyStack.pop
    }
  }

  it should "Success" in {
    succeed

    val s = "hi"
    try {
      s.charAt(-1)
      fail()
    }
    catch {
      case _: IndexOutOfBoundsException => // Expected, so continue
    }

    assertThrows[IndexOutOfBoundsException] { // Result type: Assertion
      s.charAt(-1)
    }


    val caught =
      intercept[IndexOutOfBoundsException] { // Result type: IndexOutOfBoundsException
        s.charAt(-1)
      }
    assert(caught.getMessage.indexOf("-1") != -1)

    assertDoesNotCompile("val a: String = 1")
  }

  it should "Checking that a snippet of code does or does not compile" in {
    assertDoesNotCompile("val a: Stringaa = 1")
    assertTypeError("val a: Stringf = 1")
    assertCompiles("val a: Int = 1")
  }

  ignore should "Assert test throw exception if assertion is wrong !" in {

      val a1 = 5
      fail("I've got a bad feeling about this")
      val b1 = 2
      assertResult(2) {
        a1 - b1
      }
          val left = 2
          val right = 1
       val attempted = 2
      assert(attempted == 1, "-----Execution was attempted " + left + " times instead of 1 time")

  //    val left = 2
  //    val right = 1
  //    assert(left == right)

      var a = 1
      var b = 2
      var c = 3
      var d = 4
      var xs =List(a, b, c)
      var num = 1.0

      assert(a == b || c >= d)
      // Error message: 1 did not equal 2, and 3 was not greater than or equal to 4

      assert(xs.exists(_ == 4))
      // Error message: List(1, 2, 3) did not contain 4

      assert("hello".startsWith("h") && "goodbye".endsWith("y"))
      // Error message: "hello" started with "h", but "goodbye" did not end with "y"

      assert(num.isInstanceOf[Int])
      // Error message: 1.0 was not instance of scala.Int

      assert(Some(2).isEmpty)
      // Error message: Some(2) was not empty
    }

  it should "Assumptions work" in {
    //    assume(database.isAvailable)
    //    assume(database.isAvailable, "The database was down again")
    //    assume(database.getAllUsers.count === 9)
//    cancel("Can't run the test because no internet connection was found")
//    assert(1 + 1 === 3, "this is a clue")
//    assertResult(3, "this is a clue") { 1 + 1 }
    withClue("this is a clue") {
      assertThrows[IndexOutOfBoundsException] {
        "hi".charAt(-1)
      }
    }
  }
}
