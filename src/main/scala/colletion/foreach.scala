package colletion

object foreach {
  //아무것도 반환하지 않는다.
  def main(args: Array[String]): Unit = {
    val numbers = List(1, 2, 3, 4)
    val a = numbers.foreach((i: Int) => i * 2)
    println(a)

    numbers.foreach((i: Int) => println(i))
  }
}
