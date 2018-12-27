package function

object FunctionTest {

  def main(args: Array[String]): Unit = {
    println("Function Test: " + addInt(1,2))
    //Functions Call-by-Name
    delayed(time())

    //Functions with Named Arguments
    printInt(b=2, a=3)

    //Function with Variable Arguments
    printStrings("A","B","C")

    //Recursion Functions
    println("Factorial 10: " + factorial(40))

    //Default Parameter Values
    println("A+B: " + addIntDefaultValue())
  }

  def addIntDefaultValue(a:Int = 3, b:Int = 5): Int = {
    a+b
  }

  def factorial(n:BigInt) : BigInt = {
    if(n <= 1)
      1
    else
      n * factorial(n-1)
  }

  def printStrings(args:String*) = {
    for(arg <- args) {
      println(arg + ",")
    }
    args.foreach(f => println(f + ","))
  }

  def addInt(a:Int, b:Int) : Int = {
    a+b
  }
  def time() = {
    println("Getting time")
    System.nanoTime() //or System.nanoTime
  }
  def delayed(t: => Long) = {
    println("In Delayed Method")
    println("Param: " + t) //이전 구문까지는 time()을 호출하지 않는다.
  }

  def printInt(a:Int, b:Int) = {
    println("A: " + (a+b))
    println("A: " + a+b)
    println("B: " + b)
  }
}
