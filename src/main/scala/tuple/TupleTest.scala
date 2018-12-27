package tuple

object TupleTest {
  def main(args: Array[String]): Unit = {
    println("TupleTest")
    val ts = (1, 2, 3, 4)
    println("Sum: " + (ts._1 + ts._2 + ts._3 + ts._4))

    ts.productIterator.foreach(i => println(i))

    val tus = new Tuple2("A", "B")
    println("SQSP: " + tus.swap)
  }

}
