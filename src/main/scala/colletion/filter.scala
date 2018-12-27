package colletion

object filter {
  def main(args: Array[String]): Unit = {
    val numbers = List(1, 2, 3, 4)
    val a = numbers.filter((i:Int) => i%2==0)
    println(a)

    val b = numbers.filter(isEven _)
    println(b)
  }

  def isEven(i:Int):Boolean = i%2==0
}
