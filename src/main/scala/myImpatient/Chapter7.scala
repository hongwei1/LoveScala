////
////package impatient
//////package people
////
////import impatient.com.horstman.impatient.Employee
////
/////**
////  * Created by zhanghongwei on 13/11/16.
////  */
////class Chapter7 {
////
////}
////
////object Chapter7 extends App {
////  print(com.Com1.percentOf(12.2, 12.5))
////}
////
//////BK 7.1 you can contribute to more than one package in one signle file
////
//////BK 7.2 Scope Rules
////
////package com {
////
////  object Com1 {
////    def percentOf(value: Double, rate: Double) = {
////      value * rate / 100
////      com.horstman.impatient.Employee.percentOf1(1.2, 12.3)
////    }
////  }
////
////  package horstman {
////
////    object Utils {
////      def percentOf(value: Double, rate: Double) = {
////        value * rate / 100
////        Employee.percentOf1(1.2, 12.3)
////        Com1.percentOf(1.2, 2.4)
////      }
////    }
////    package impatient {
////
////      class Employee {
////
////        var salary = 1.0
////
////        def giveRaise(rate: scala.Double): Unit = {
////          salary += Utils.percentOf(salary, rate)
////        }
////      }
////
////      object Employee {
////        def percentOf1(value: Double, rate: Double) = value * rate / 100
////      }
////
////    }
////
////  }
////
////}
////
//////bk 7.3 Chained Package Clauses
////
////package com.horstman.impatient {
////  // Members of com and com.horstmann are not visible here
////  package people {
////
////    class Person {
////
////    }
////
////  }
////
////}
////
////
//////bk 7.4 Top-of-File Notation
//////package com.horstman.impatient.people
////////everything in the file belongs to the package com.horstmann.impatient.people,
////////but the package com.horstmann.impatient has also been opened up so you can refer to its contents.
//////package people {
//////  class Person
//////}
////
////bk 7.5 Package Objects
//package com.horstman.impatient.packageobject
//
//import java.util
//
//import scala.collection.mutable
//
//
//package object people {
//  val defaultName = "John Q. Public "
//}
//package people {
//
//  class Person {
//    var name = defaultName // A constant from the package
//  }
//
//  object Person {
//    var name = defaultName // A constant from the package
//  }
//
//}
//
//object test extends App {
////  people.defaultName
//}
//
////bk 7.8 Imports Can Be Anywhere
//class Manager {
//  import scala.collection.mutable._
//  import com.horstmann.impatient.Employee
//
//  val subordinates = new ArrayBuffer[Employee]
//}
////BK 7.9 Renaming and Hiding Members
//class Class79 {
//  import java.awt.{Color, Font}
//  import java.util.{HashMap => JavaHashMap}
//  import scala.collection.mutable._
//  mutable.HashMap
//  JavaHashMap
//  util.HashMap
//
//  import java.util.{HashMap => _, _}
//  import scala.collection.mutable._
//  util.HashMap
//  import java.lang._
//  import scala._
//  import Predef._
//}
