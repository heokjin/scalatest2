package colletion

object zip {
  def main(args: Array[String]): Unit = {
    val l1 = List(1,2,3)
    val l2 = List(5,6,7)

    val a = l1.zip(l2)
    println(a)
  }
}
