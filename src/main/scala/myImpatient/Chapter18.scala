package myImpatient

import java.awt.{Point, Rectangle}
import java.awt.geom.Area
import java.awt.image.BufferedImage
import java.io.{File, Serializable}
import javax.imageio.ImageIO
import javax.swing.JComponent

import com.sun.javafx.collections.MappingChange.Map

import scala.collection.mutable.ArrayBuffer
import scala.io.Source

/**
  * Created by zhanghongwei on 15/11/16.
  */
class Chapter18 {

}

//bk 18. Advanced Types 22=281-259
object AdvancedTypes1 {
}

//bk? 18.1 Singleton Types 259
object SingletonTypes1 extends App {
  val chapter = new Chapter18

  val article: Document = new Document
  article.setTitle("Love you ").setAuthor("Hongwei")

  //  v.type v null
  // eg1: return this, can connect together
  class Document {
    def setTitle(title: String): this.type = {
      print("Set Title : " + title);
      this
    }

    def setAuthor(author: String): this.type = {
      print("Set Author :" + author);
      this
    }
  }

  //eg2: if you have subclass ,the problem
  class Book extends Document {
    def addChapter(chapter: String) = {
      print("add chapter =" + chapter);
      this
    }
  }

  val book = new Book()
  book.addChapter("add ").setTitle("Scala for the Impatient") // right
  book.setTitle("Scala for the Impatient").addChapter("add ") // Wrong !!!
  //solution: use this.type. it return the book.type


  //eg3:accept boject instance as parameter, you also can use singleton type


}

//bk 18.2 Type Projections
object TypeProjections2 {

  import scala.collection.mutable.ArrayBuffer

  class Network {

    class Member(val name: String) {
      val contacts = new ArrayBuffer[Network#Member] // “a Member of any Network.
    }

    private val members = new ArrayBuffer[Member]

    def join(name: String) = {
      val m = new Member(name)
      members += m
      m
    }
  }

}

//bk 18.3 Paths
object Paths3 {
  //  com.hotstmann.impatient.chatter.Member
  //  com.hotstmann.impatient.Network.Member : accoumpany object
  //Such an expression is called a path.
  //package ,object ,val ,this,
}

//bk 18.4 Type Aliases
object TypeAliases4 {

  //  You can create a simple alias for a complicated type with the type keyword,
  //eg1:
  class Book {

    import scala.collection.mutable._

    type Index = HashMap[String, (Int, Int)]
  }

  // you can use Book.Index == scala.collection.mutable.HashMap[String ,(Int,Int)]

  //eg2:
  abstract class Reader {
    type Contents

    def read(fileName: String): Contents
  }

}

//bk 18.5 Structural Types
// A “structural type” is a specification of abstract methods, fields, and types
// that a conforming type should possess.
object StructuralTypes5 extends App {

  object Appender extends App {
    def appendLines(target: {def append(str: String): Any},
                    lines: Iterable[String]) {
      for (l <- lines) {
        target.append(l); target.append("\n")
      }
    }

    val lines = Array("Mary", "had", "a", "little", "lamb")

    val builder = new StringBuilder
    appendLines(builder, lines)
    println(builder)

    import javax.swing._

    val area = new JTextArea(20, 20)
    appendLines(area, lines)

    val frame = new JFrame
    frame.add(area)
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    frame.pack()
    frame.setVisible(true)
  }

}

//bk 18.6 Compound Types
// form: T1 with T2 with T3
// T1 ,T2 ,T3 is type, if want to be instance , it need to meet all the requirements.
// IT is an intersection type.
object CompoundTypes6 {
  //eg1
  val image = new ArrayBuffer[java.awt.Shape with java.io.Serializable]

  val rect = new Rectangle(5, 10, 20, 30)
  image += rect // OK ==Eectangle is both shape nad serialibable
  //  image += new Area(rect) // Error --> Area is Shape ,but not serializable

  //eg2 mix structurl Type and compound type
  //  class myShape with Serializable {def contains (p:Point):Boolean}
  //  it both the sub class of Serializable and Shape , and contains one method having Point parameter


  //eg3:
  //  {def append(str:String):Any}
  //  is short for
  //  AnyRef { def append(str :String):Any}

  //  Shape with Serializable
  //  is short for
  //  Shape with Serializable{}


}

//bk 18.7 Infix Types
//An infix type is a type with two type parameters, written in “infix” syntax,
// with the type name between the type parameters.
object InfixTypes7 {
  //  eg1:
  // String Map Int
  //  not  Map[String,Int]

  type ×[A, B] = (A, B)

}

//bk 18.8 Existential Types
//Existential types were added to Scala for compatibility with Java wildcards.
object ExistentialTypes8 {

  //  An existential type is a type expression followed by forSome { ... },
  // where the braces contain type and val declarations.
  //  Array[T] forSome {type T <:JComponent}
  //  ==
  //  Array[_ <: JComponent]

  //eg2 scala wildcards are  syntactic sugar
  //  Array[_] == Array[T] forSome {type T}
  // Map[_,_] == Map[T,U] forSome{type T; type U}
}

//bk 18.9 The Scala Type System
// 10 types
// 1 Class or Trait  2 Tuple type       3 Function Type  4 Annotated Type  5  Parameterized Type
// 6 Singleton       7 Type Projectioin 8 Compound Type  9 Infix Type      10 Existential Type
object TypeSystem9 {

}

//bk 18.10 Self Types
//how a trait can require that it is mixed into a class that extends another type
//this: Type
object SelfTypes10 {

  //eg1 : LoggedException can only mixed a class that extends Exception
  trait Logged {
    def log(msg: String)
  }

  trait LoggerException extends Logged {
    this: Exception =>
    def log() {
      log(getMessage) // OK to call getMessage because this is an Exception
    }
  }

  // Error: JFrame isn't a subtype of Exception,
  // the self type of LoggedException
  // val f = new JFrame with LoggerException

  //eg2 : require multiple types, use a compound type

}

//bk? 18.11 Dependency Injection
object DependencyInjection11 {

  //eg1:
  trait Logger {
    def log(msg: String)
  }

  trait Auth {
    this: Logger =>
    def login(id: String, password: String): Boolean
  }

  trait App {
    this: Logger with Auth =>
  }

  //  object MyApp extends App with FileLogger("test.log") with MockAuth("user.txt")


}

//bk 18.12 Abstract Types
object AbstractTypes12 {

  //  A class or trait can define an abstract type that is made concrete in a subclass.
  //eg1:
  trait Reader {
    type Contents

    // is abstract
    def read(fileName: String): Contents
  }

  class StringReader extends Reader {
    type Contents = String

    def read(fileName: String) = Source.fromFile(fileName, "UTF-8").mkString
  }

  class ImageReader extends Reader {
    type Contents = BufferedImage

    // is abstract
    def read(fileName: String): BufferedImage = ImageIO.read(new File(fileName))
  }

  //eg2 : same logic using Type parameter:

//  trait Reader[C] {
//
//    def read(fileName: String): C
//  }
//
//  class StringReader extends Reader[String] {
//
//    def read(fileName: String) = Source.fromFile(fileName, "UTF-8").mkString
//  }
//
//  class ImageReader extends Reader[BufferedImage] {
//
//    def read(fileName: String) = ImageIO.read(new File(fileName))
//  }

}

//bk??? 18.13 Family Polymorphism
object FamilyPolymorphism13 {

}

//bk 18.14 Higher-Kinded Types
object HigherKindedTypes14 {

}
