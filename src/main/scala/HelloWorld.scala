object HelloWorld {
  def main(args: Array[String]) {
    val longA = 1L
    if (longA > 0) println("P") else println("N")

    var myVar : Int = 10;
    val myVal : String = "Hello Scala"
    myVar = 1
    //myVal = "A"; error

    var myVar1 = 20;
    val myVal1 = "Hello Scala1"

    println(myVar); println(myVal); println(myVar1);
    println(myVal1)

    val (myVar2: Int, myVar3: String) = Pair(40, "Foo")
    println(myVar2, myVar3)

    println("Myval2:", myVar2)
    println("Myval2:" + myVar2)

    var A = 0x00000001  //16진수
    var B = 0x00000011

    println(A&B)
    println(A^B)

    if (A > 0) {
      println("A > 0")
    } else {
      println("A < 0")
    }

  }

  def addInt( a:Int, b:Int ) : Int = {
    var sum:Int = 0
    sum = a + b

    return sum
  }
}