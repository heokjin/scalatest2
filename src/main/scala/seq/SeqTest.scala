package seq

object SeqTest {

  def main(args: Array[String]): Unit = {
    val a = Seq("a", "b", "c")
    val aa = Seq()
    val b = a.contains("b")

    println(b)
    println(aa.tail)
  }

}
