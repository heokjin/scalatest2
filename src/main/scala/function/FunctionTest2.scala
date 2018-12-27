package function

import java.util.Date

object FunctionTest2 {
  def main(args: Array[String]): Unit = {
    println("FunctionTest2")

    //Higher-Order Functions
    println(apply(layout, 10))

    //Nested Functions
    println(factorial(5))

    //Anonymous Functions
    var inc = (x:Int) => x+1
    var userDir = () => {System.getProperty("user.dir")}
    println(userDir)

    //Partially Applied Functions
    val date = new Date()
    log(date, "Day1")

    //Currying Functions
    println(strcat("AA")("BB"))
    println(strcat2("RRR")("EEE"))

  }

  def strcat(s1:String)(s2:String) = s1+s2
  def strcat2(s1:String) = (s2:String) => s1+s2

  def log(date:Date, msg:String) = {
    println(date + "-----" + msg)
  }

  def apply(f:Int => String, v:Int) = f(v)
  def layout[A](x:A) = "["+x.toString+"]"

  def factorial(i:Int): Int = {
    def fact(i:Int, accumulator:Int): Int = {
      if(i<=1)
        accumulator
      else
        fact(i-1, i * accumulator)
    }
    fact(i, 1)
  }
}
