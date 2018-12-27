package iterator

object IteratorTest {
  def main(args: Array[String]) : Unit = {
    println("Iterator test")

    val it = Iterator(1,2,3,4)
    while(it.hasNext) {
      println(it.next())
    }

    val it2 = Iterator(1,2,3,4)
    println("Max: " + it2.max)
    println("Length: " + it2.length)
  }
}
