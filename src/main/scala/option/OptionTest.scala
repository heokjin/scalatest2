package option

object OptionTest {
  def main(args: Array[String]): Unit = {
    println(("OptionTest"))
    val capitals = Map("korea" -> "seoul", "japan"->"tokyo", "france"->"paris")

    println(capitals.get("korea"))
    println(capitals.get("korea1"))

    println("Option: " + show(capitals.get("Red1")))

    val a:Option[Int] = Some(5)
    val b:Option[Int] = None
    println(a.getOrElse(0))
    println(b.getOrElse(0))
  }

  def show(x:Option[String]) = x match {
    case Some(s) => s
    case None => "?"
  }

}
