package colletion

object map {
  //List를 반환한다.
  def main(args: Array[String]): Unit = {
    val numbers = List(1, 2, 3, 4)
    numbers.map((i: Int) => print(i))
    println()
    val b = numbers.map((i: Int) => i * 2)
    println(b)

    val c = numbers.map(timesTwo _)
    println(c)
  }

  def timesTwo(i: Int): Int = i*2
}
