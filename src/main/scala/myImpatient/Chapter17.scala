package myImpatient

/**
  * Created by zhanghongwei on 15/11/16.
  */
class Chapter17 {

}


object Chapter17 {
  //BK 17.1 Generic Classes
  class Pair[T,S] (val first:T ,val second:S){}
  // varible ,paramter and return value
  Pair[Int,String] // ordinary class
  //infer actual types
  val p = new Pair(28,"Hongwei")
  // you can specify the types
  val p2 =new Pair[Any,Any](42,"String")

  //BK 17.2 Generic Functions



}






















